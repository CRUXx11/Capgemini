abstract class Persistence {
    abstract public String persist();
}
class FilePersistence extends Persistence{
    @Override
    public String persist() {
        return "FilePersistence";
    }
}
class DatabasePersistence extends Persistence{
    @Override
    public String persist() {
        return "DatabasePersistence";
    }
}
//As persistence is abstract class we cannot make its object
class client extends Persistence{
    public String persist() {
        return "client";
    }
}
public class Assignment2Q6 {
    public static void main(String[] args) {}
}