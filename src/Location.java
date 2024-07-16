import java.util.*;

public class Location {
    String name;
    String description;
    String here;
    Item item;
    Entities[] Entitieshere = new Entities[5];

    Item[] itemsHere = new Item[4]; 

    Location[] exits; 

    public Location() {
    };

    public Item getItem(String objectName) {
        return itemsHere[0]; 
    }
}
