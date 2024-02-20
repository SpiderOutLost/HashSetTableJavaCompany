public class CompanyHash  {
    private static final double LOAD_FACTOR = 0.75;
    private final int INITIAL_CAPACITY = 16;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private static class Entry{
        private final Company data;
        Entry next;

        public Entry(Company data, Entry next) {
            this.data = data;
            this.next = next;

        }
    }
    boolean add(String CompanyLine){
        String[] s = CompanyLine.split(" ");
        Company company = new Company(s[0],s[1], s[2],s[3]);
        if (size >= array.length * LOAD_FACTOR) {
            increaseArray();
        }
        boolean added = add(company, array);
        if (added){
            size++;
        }
        return added;
    }
    private boolean add(Company company, Entry[] dst){
        int position = getElementPosition(company, dst.length);
        if (dst[position] == null){
            Entry entry = new Entry(company, null);
            dst[position] = entry;

            return true;
        }
        else {
            Entry entryExistedElement = dst[position];
            while (true){
                if (entryExistedElement.data.equals(company)){
                    return false;
                }
                else if(entryExistedElement.next == null ){
                    entryExistedElement.next = new Entry(company, null);
                    return true;
                }
                else {
                    entryExistedElement = entryExistedElement.next;
                }
            }
        }
    }
  public void FindCompany(String CompanyLine) {
      String[] s = CompanyLine.split(" ");
      Company company = new Company(s[0],s[1], s[2],s[3]);
      int position = getElementPosition(company, array.length); // где на каком месте есть элемент, буду передавать ссылки
      Entry needFindElement = array[position];
      while (needFindElement!= null) {
          if (needFindElement.data.equals(company)) {
              System.out.println("Компания есть");
              return;
          }
          needFindElement = needFindElement.next;
      }
      System.out.println("Компанния не найдена");
  }
    boolean remove(String CompanyLine) {
        String[] s = CompanyLine.split(" ");
        Company company = new Company(s[0],s[1], s[2],s[3]);
        int position = getElementPosition(company, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondlast = array[position];
        Entry last = secondlast.next;
        if (secondlast.data.equals(company)) {
            array[position] = last;
            size--;
            return true;
        }
        while (last != null) {
            if (last.data.equals(company)) {
                secondlast.next = last.next;
                size--;
                return true;
            } else {
                secondlast = last;
                last = last.next;
            }
        }
        return false;
    }
    void clear(){
        array = new  Entry[INITIAL_CAPACITY];
        size = 0;
    }
    private int getElementPosition(Company company, int arrayLength){
        return Math.abs(company.hashCode() % arrayLength);
    }

    public int getSize() {
        return size;
    }
    private void increaseArray(){
        Entry[] newArray = new Entry[array.length * INITIAL_CAPACITY];
        for (Entry entry:array
             ) {
            Entry existedelement = entry;
            while (existedelement!=null){
                add(existedelement.data,newArray);
                existedelement = existedelement.next;
            }
        }
        array = newArray;
    }

    public void Print(){

        for (Entry entry: array
             ) {
            if (entry != null){
                System.out.print(entry.data.PrintCompany());
                if (entry.next != null) System.out.println(" -> " + entry.next.data.PrintCompany());
                else {
                    System.out.println();
                }
            }

        }
    }
}
