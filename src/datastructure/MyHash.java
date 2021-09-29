package datastructure;

public class MyHash {



    public static void main(String[] args) {
        MyHash mainObject = new MyHash(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        System.out.println(mainObject.getData("DaveLee"));
        System.out.println(mainObject.getData("fun-coding"));
    }

    public Slot[] hashTable;

    public MyHash(int length) {
        this.hashTable = new Slot[length];
    }

    public Integer hashFunction(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunction(key);
        if (hashTable[address] != null) {
            hashTable[address].value = value;
        } else {
            hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = hashFunction(key);
        if (hashTable[address] != null) {
            return hashTable[address].value;
        } else {
            return null;
        }
    }

    public static class Slot {
        String value;

        Slot(String value) {
            this.value = value;
        }
    }

}
