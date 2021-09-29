package datastructure;

public class MyHash02 {

    public static void main(String[] args) {
        MyHash02 mainObject = new MyHash02(20);
        System.out.println(mainObject.saveData("DaveLee", "01022223333"));
        System.out.println(mainObject.saveData("fun-coding", "01033334444"));
        System.out.println(mainObject.saveData("David", "01044445555"));
        System.out.println(mainObject.saveData("Dave", "01055556666"));
        System.out.println(mainObject.getData("DaveLee"));
        System.out.println(mainObject.getData("fun-coding"));
        System.out.println(mainObject.getData("David"));
        System.out.println(mainObject.getData("Dave"));
        int a = 1;
        while(a<4) {
            System.out.println(a);
            a++;
        }

    }

    private LinkedSlot[] hashTable;

    public MyHash02(int length) {
        this.hashTable = new LinkedSlot[length];
    }

    public int hashFunction(String key) {
        return (int) (key.charAt(0)) % hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = hashFunction(key);
        if (hashTable[address] != null) {
            LinkedSlot recentSlot = hashTable[address];
            LinkedSlot prevSlot = recentSlot;
            while (recentSlot != null) {
                if (recentSlot.key == key) {
                    recentSlot.value = value;
                    return true;
                } else {
                    prevSlot = recentSlot;
                    recentSlot = recentSlot.next;
                }
            }
            prevSlot.next = new LinkedSlot(key, value);
        } else {
            hashTable[address] = new LinkedSlot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        int address = hashFunction(key);
        if (hashTable[address] != null) {
            LinkedSlot recentSlot = hashTable[address];
            while (recentSlot != null) {
                if (recentSlot.key == key) {
                    return recentSlot.value;
                } else {
                    recentSlot = recentSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    class LinkedSlot {
        String key;
        String value;
        LinkedSlot next;

        public LinkedSlot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }


}
