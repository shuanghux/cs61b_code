public class Dog implements ourComparable{
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(ourComparable o) {
        Dog outdog = (Dog) o;
        return (this.size - outdog.size);
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }
}