package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 *
 * 02-07-2014 ajochems
 * Changed the coin definition settings to the appropriate CasinoCoin settings
 */
public class CoinDefinition {


    public static final String coinName = "CasinoCoin";
    public static final String coinTicker = "CSC";
    public static final String coinURIScheme = "casinocoin";
    public static final String cryptsyMarketId = "68";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "Q";

    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://csc.blockexp.info/";
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "CRBZujsRrUCeYu3nyzRTcRoneNwJ2RR3GA";  //MegaMineros donation CSC address

    enum CoinHash {
        SHA256,
        scrypt,
    };

    public static final CoinHash coinPOWHash = CoinHash.scrypt;

    public static boolean checkpointFileSupport = true;
    public static int checkpointDaysBack = 21;

    public static final int TARGET_TIMESPAN = (int)(0.25 * 24 * 60 * 60);  // 6 hours / 0.25 days per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(1 * 30);  // 30 seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;

    public static final int getInterval(int height, boolean testNet) {
        return INTERVAL;
    }

    public static final int getIntervalCheckpoints() {
        return INTERVAL;
    }

    public static final int getTargetTimespan(int height, boolean testNet) {
        return TARGET_TIMESPAN;
    }

    public static int getMaxTimeSpan(int value, int height, boolean testNet) {
        return value * 75 / 60;
    }

    public static int getMinTimeSpan(int value, int height, boolean testNet) {
        return value * 55 / 73;
    }

    public static int spendableCoinbaseDepth = 8; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(336000000).multiply(Utils.COIN);                 //main.h:  MAX_MONEY

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(10000000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = Utils.CENT; //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70003;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70003;        //version.h MIN_PROTO_VERSION - eliminate 60001 which are on the wrong fork

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1000000;


    public static final boolean supportsBloomFiltering = false;

    public static final int Port    = 47950;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 17950;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 28;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = true; //for backward compatibility with previous version of casinocoin
    public static final long PacketMagic = 0xfac3b6da;      //0xfa, 0xc3, 0xb6, 0xda

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1372838150L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (16762L);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "4f46c9af6d88a14114b7dc53a37d81ba4064cda5ae2ede1213ca28fea9b86e9c"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 0;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer with height 0
    static public String genesisMerkleRoot = "73d304deca65f150913c0f87305dec7aa3913919889e483aa04bda87133023e6";
    static public String genesisTxInBytes = "04ffff001d0104344e592054696d657320322f4a756c792f32303133205768617420746865204e2e532e412e204b6e6f77732041626f757420596f75";   //"NY Times 2/July/2013 What the N.S.A. Knows About You"
    static public String genesisTxOutBytes = "00ac";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "195.241.255.78",
            "162.242.217.120",
            "216.177.81.87",
            "68.110.80.22",
            "84.127.38.52",
            "220.189.247.202",
            "222.94.107.90",
            "182.173.123.181",
            "74.208.97.13",
            "63.170.87.173",
            "162.242.227.236"
    };

    public static int minBroadcastConnections = 1;   //0 for default; we need more peers.

    //
    // TestNet - casinocoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 87;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xfcc1b7dc;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "60cf36f96baf1c3d882c9f155ee3dfc3a1cb5a47071d797f606714db54f4b5e8";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 999999L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (99999);                         //main.cpp: LoadBlockIndex

    //main.cpp GetBlockValue(height, fee)
    public static final BigInteger GetBlockReward(int height)
    {
        // set default to 50 CSC coins
        int COIN = 1;
        BigInteger nSubsidy = Utils.toNanoCoins(50, 0);

        if(height < 720)
        {
            nSubsidy = Utils.toNanoCoins(35, 0); //2
        }
        else if(height < 1440)
        {
            nSubsidy   = Utils.toNanoCoins(5, 0); //2
        }
        else if(height < 2160)
        {
            nSubsidy   = Utils.toNanoCoins(10, 0); //2
        }
        else if(height < 2880)
        {
            nSubsidy  = Utils.toNanoCoins(15, 0); //5
        }
        else if(height < 3600)
        {
            nSubsidy  = Utils.toNanoCoins(20, 0); //8
        }
        else if(height < 4320)
        {
            nSubsidy = Utils.toNanoCoins(25, 0); //11
        }
        else if(height < 5040)
        {
            nSubsidy  = Utils.toNanoCoins(30, 0); //14
        }
        else if(height < 5760)
        {
            nSubsidy = Utils.toNanoCoins(35, 0); //17
        }
        else if(height < 6480)
        {
            nSubsidy = Utils.toNanoCoins(40, 0); //2
        }
        else if(height < 7200)
        {
            nSubsidy = Utils.toNanoCoins(45, 0); //2
        }
        else
        {
            return nSubsidy.shiftRight(height / subsidyDecreaseBlockCount);
        }
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 3153600;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // casinocoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "04fc9702847840aaf195de8442ebecedf5b095cdbb9bc716bda9110971b28a49e0ead8564ff0db22209e0374782c093bb899692d524e9d6a6956e7c5ecbcd68284";
    public static final String TESTNET_SATOSHI_KEY = "";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.casinocoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.casinocoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.jochems.casinocoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints) {
        checkpoints.put( 0, new Sha256Hash("4f46c9af6d88a14114b7dc53a37d81ba4064cda5ae2ede1213ca28fea9b86e9c"));
        checkpoints.put( 1, new Sha256Hash("d6eea1064e9292f2a38e138bec64797914cff3189fbc6eaa2cc646c1514ccdfe"));
        checkpoints.put( 777, new Sha256Hash("838c9d331811479957009c39d2e1e723d47ebd21453b3ad92bcabd6cb5dd6ab1"));
        checkpoints.put( 7777, new Sha256Hash("09ab8471911e0f19e19ef09e1ae212b389f6be3e62f0c140d58c27084da08907"));
        checkpoints.put( 17777, new Sha256Hash("4dd8c993bdb32b5ff63a1108f86b1cf2b6f3fb3e5a831d3445d944b986addadf"));
        checkpoints.put( 27777, new Sha256Hash("ea7623cc7d0db290b4f2bf5b1d5cbf477bf0c019b667d21dbc5e82e12adcf3ae"));
        checkpoints.put( 37777, new Sha256Hash("ced9dadf09278f513337ebbeee11804b794faddf8f759e583a1e39b0839c238a"));
        checkpoints.put( 47777, new Sha256Hash("b59586840946941d9fd92dc378e0f2bd5fa4da0ebd0636dc009acc2a0174e048"));
        checkpoints.put( 57777, new Sha256Hash("fdf6fa6f606f3b14e7b2084b0e60a80b769c2ae04fbea62d1af78674d3d1ef76"));
        checkpoints.put( 67777, new Sha256Hash("5c6732d5ec60454ce68579cf88118923ebdd5dc82b372310bcf7d7303ffddf39"));
        checkpoints.put( 77777, new Sha256Hash("4fa19ce5f0a050cbf13b3ad194c39351276a7e587ccdef03fa926429b00a0d44"));
        checkpoints.put( 87777, new Sha256Hash("278d5a4d6ee24dfa263e33032ef0496e0e6d43d9f1918dc269dc83c56d29199c"));
        checkpoints.put( 97777, new Sha256Hash("f1ab4d14a7a9797d4c22336aea6d83db6a2e5c7f07121d5b67b958e37ea5e384"));
        checkpoints.put( 107777, new Sha256Hash("421ac0aed1cfb4226d4936fa0ac93c45cce9c6bec7aca4e329a672d8414b23ec"));
        checkpoints.put( 117777, new Sha256Hash("731713bd84c9fd90cebc6c85c56cd071bd0826841fa1ff193250c9dd897650eb"));
        checkpoints.put( 127777, new Sha256Hash("d90c1bb94b4aea5dcb4cb4a03de76190e7b1cf2e14fd45dc8a1e317066118491"));
        checkpoints.put( 137777, new Sha256Hash("97972ecfc9efd19567f49c96f3bfaad15b3cc63ce0aac1780c1276624e41e9a2"));
        checkpoints.put( 147777, new Sha256Hash("e83328402d705d53074cce0deb98f09b9016357063b522d30dbc450d241a073d"));
        checkpoints.put( 157777, new Sha256Hash("86b45c6144bcdff90b2846e1669fdd49392e2c9eef6132184afc1a9434ef43a0"));
        checkpoints.put( 167777, new Sha256Hash("065a4f24bf79b45353e456e74a75194be95d49bb9fbe2ef0771b0ff4a2c86ac6"));
        checkpoints.put( 177777, new Sha256Hash("221fff51bd7a48c300b863ff5edb82dacf893ea908c00c4f6915789bed0d27b2"));
        checkpoints.put( 187777, new Sha256Hash("ad3c4d3b73493cb9c888b30f550db4fda6a5ff8c6daa20404285e354c3a4c7a1"));
        checkpoints.put( 197777, new Sha256Hash("2f9203c38cede6e1c61a69eb43c4f62d8e04ba62a57a7d866f4d715eec033cd4"));
        checkpoints.put( 207777, new Sha256Hash("3631874522954f18e6834ad68918dcc060b2712fea7a381e11e10193c6ab2f24"));
        checkpoints.put( 217777, new Sha256Hash("c86150e3408be1ca10eb1b94f374ae331c07dec6e2162bf06f5c31d83faa9715"));
        checkpoints.put( 237777, new Sha256Hash("6f9d56c970ec057c9d6b20e930e50811d8b5d0215046c80bb681d914e2cca4ea"));
        checkpoints.put( 257777, new Sha256Hash("53e08f4dfe94f5c489aeb564ba84b5e131d026827533f7b446e956541c94eab2"));
        checkpoints.put( 277777, new Sha256Hash("69f7a0b78bf4609971af3702ffd8d2dec7df07d784240aaa28a67d0c78365668"));
        checkpoints.put( 297777, new Sha256Hash("e1b8520b0cc8e03785330dcee2bd31415f44b90f6af9176336859a6230c09de2"));
        checkpoints.put( 317777, new Sha256Hash("0458c7effe8348b551f47c3d7115c9347f4121749549650d495b88e8d0a9c666"));
        checkpoints.put( 347777, new Sha256Hash("9ba10b9cd9b94e903e67da6a1033841a3e66b6a33f09cbaec2146d4f72dbea2d"));
        checkpoints.put( 377777, new Sha256Hash("6eecff79e07910c69ac5340ad34c74cd95ecdfb0282ac62b30e7ba443114a628"));
        checkpoints.put( 444429, new Sha256Hash("01f8b85612927fd3660e7e036f559770ebb09d896f54abf70d99be2fe1793155"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "Cxxxxxxxxxxxxxxxxxxxxxxxxxx";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "Qxxxxxxxxxxxxxxxxx";

}
