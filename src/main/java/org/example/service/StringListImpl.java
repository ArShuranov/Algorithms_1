package org.example.service;

//my own realisation ArrayList (String[])

public class StringListImpl implements StringList {
    private String[] stringList = new String[0];
    private String[] buffer_1 = new String[0];

    public String[] getStringList() {
        return stringList;
    }

//when adding an element a new array is created 1 more
    @Override
    public String add(String item) {
        if (item != null) {
            buffer_1 = stringList;
            stringList = new String[stringList.length + 1];

            for (int i = 0; i < buffer_1.length; i++) {
                stringList[i] = buffer_1[i];
            }
            stringList[stringList.length - 1] = item;
        }
        return stringList[stringList.length - 1];
    }

//This is how we add an element by index. A new array is also created 1 more.
    @Override
    public String add(int index, String item) {
        if (index > stringList.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            buffer_1 = stringList;
            stringList = new String[stringList.length + 1];
            stringList[index] = item;
            for (int i = 0; i < stringList.length - 1; i++) {
                if (i < index) {
                    stringList[i] = buffer_1[i];
                } else {
                    stringList[i + 1] = buffer_1[i];
                }
            }
        }

        return stringList[index];
    }

//change the value of an element by index
    @Override
    public String set(int index, String item) {
        if (index >= stringList.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            stringList[index] = item;
            return stringList[index];
        }
    }

//If there is such an element, then we reduce our array by 1.
// If not, then an exception will be thrown when comparing the arrays.
// We find the index of this element, and then assign all the elements to a new array except for the one to be removed.
    @Override
    public String remove(String item) {
        int divider = 0;
        buffer_1 = stringList;

        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                divider = i;
                stringList = new String[stringList.length - 1];
                break;
            }
        }

        if (stringList.length == buffer_1.length) {
            throw new RuntimeException("Такой элемент отсутствует");
        }

        for (int j = 0; j < stringList.length; j++) {
            if (j < divider) {
                stringList[j] = buffer_1[j];
            } else {
                stringList[j] = buffer_1[j + 1];
            }
        }
        return item;
    }

//Almost the same as above
    @Override
    public String remove(int index) {
        if (index >= stringList.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            buffer_1 = stringList;
            stringList = new String[stringList.length - 1];

            for (int j = 0; j < stringList.length; j++) {
                if (j < index) {
                    stringList[j] = buffer_1[j];
                } else {
                    stringList[j] = buffer_1[j + 1];
                }
            }
        }
        return buffer_1[index];
    }
//if contains item return true/false
    @Override
    public boolean contains(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }
//if contains item return index or -1
    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    //search element from the end return index or -1
    @Override
    public int lastIndexOf(String item) {
        for (int i = stringList.length - 1; i > 0; i--) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
//get element by index or exception if index > length
    @Override
    public String get(int index) {
        if (index >= stringList.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stringList[index];
    }
//comparison of two lists
    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new RuntimeException("передан null");
        }
        if (stringList.length != otherList.size()) {
            return false;
        }
        for (int i = 0; i < stringList.length; i++) {
            if (!stringList[i].equals(otherList.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return stringList.length;
    }

    @Override
    public boolean isEmpty() {
        if (stringList.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        stringList = null;
    }

    @Override
    public String[] toArray() {
        String[] result = stringList;
        return result;
    }

}

