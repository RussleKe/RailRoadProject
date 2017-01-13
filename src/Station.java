/**
 * Created by RuslanKuleshov on 13.01.17.
 */
public class Station extends NamedEntity {
    private String description;

    public Station(){

    }

    public Station(String name, String description){
        super(name);
        this.description = description;

    }

    public String getDescription(){
        return description;
    }

    public void String setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return "Station" +
                "description'" + description + '\'' + '}';

    }
}
