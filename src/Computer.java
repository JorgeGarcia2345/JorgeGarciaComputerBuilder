/*

Class Composition
"Has a relationship" Computer HAS A CPU / RAM / Storage / VideoCard
Computer is the OUTER class

Inner Classes:
CPU
RAM
Storage
VideoCard

 */

import java.text.NumberFormat;

// OuterClass
// AFter Compiled = Computer.class (Intermediate code / byte code)
// each inner class becomee written as well, Computer$CPU.class
public class Computer
{
    private NumberFormat currency = NumberFormat.getCurrencyInstance();
    // this = computer
    private CPU mCPU;
    private RAM mRAM;
    private Storage mStorage;
    private VideoCard mVideoCard;

    public CPU getCPU() {return mCPU;}
    public RAM getRAM() {return mRAM;}
    public Storage getStorage() {return mStorage;}
    public VideoCard getVideoCard() {return mVideoCard;}

    public double calculateCost() {
        // add up all the prices of all the parts
        double total = 0.00;
        if (mCPU!=null)
            total+=mCPU.mPrice;
        if (mRAM!=null)
            total += mRAM.mPrice;
        if (mStorage!=null)
            total += mStorage.mPrice;
        if (mVideoCard!=null)
            total += mVideoCard.mPrice;
        return total;
    }

    public String toString()
    {
        return  "~~~~~Computer Specifications~~~\n" +
                mCPU + "\n" +
                mRAM + "\n" +
                mStorage + "\n" +
                mVideoCard + "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Total Cost as configured: " + currency.format(calculateCost());
    }

    // Nested inner Classes
    class CPU{
        private String mManufacturer;
        private String mCore;
        private double mSpeed;
        private double mPrice;

        public CPU(String manufacturer, String core, double speed, double price) {
            mManufacturer = manufacturer;
            mCore = core;
            mSpeed = speed;
            mPrice = price;
            mCPU = this;
            // current ob that your currently in
            // this = cpu
        }

        @Override
        public String toString() {
            return "CPU[" +
                    mManufacturer +
                    " " + mCore +
                    " " + mSpeed + " GHz" +
                    " " + currency.format(mPrice) +
                    ']';
        }
    }

    class RAM {
        private String mManufacturer;
        private double mCapacity;
        private double mSpeed;
        private double mPrice;

        public RAM(String manufacturer, double capacity, double speed, double price) {
            mManufacturer = manufacturer;
            mCapacity = capacity;
            mSpeed = speed;
            mPrice = price;
            mRAM = this;
        }

        @Override
        public String toString() {
            return "RAM[" +
                    mManufacturer +
                    " " + mCapacity +
                    " " + mSpeed + " RAM" +
                    " " + currency.format(mPrice) +
                    ']';
        }
    }

    class Storage {
        private String mManufacturer;
        private String mType;
        private double mCapacity;
        private double mPrice;

        public Storage(String manufacturer, String type, double capacity, double price) {
            mManufacturer = manufacturer;
            mType = type;
            mCapacity = capacity;
            mPrice = price;
            mStorage = this;
        }

        @Override
        public String toString() {
            return "Storage[" +
                    mManufacturer +
                    " " + mCapacity +
                    " " + mType + " Type" +
                    " " + currency.format(mPrice) +
                    ']';
        }
    }

    class VideoCard {
        private String mManufacturer;
        private double mCapacity;
        private String mMaxRes;
        private double mPrice;

        public VideoCard(String manufacturer, double capacity, String maxRes, double price) {
            mManufacturer = manufacturer;
            mCapacity = capacity;
            mMaxRes = maxRes;
            mPrice = price;
            mVideoCard = this;
        }

        @Override
        public String toString() {
            return "RAM[" +
                    mManufacturer +
                    " " + mCapacity +
                    " " + mMaxRes + " MaxRes" +
                    " " + currency.format(mPrice) +
                    ']';
        }
    }
}
