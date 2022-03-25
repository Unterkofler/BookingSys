package writeside;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StorageWrite {
    private List<String> storage = new ArrayList<>();

    public StorageWrite(){}

    public boolean add(String data){
        boolean isadded = this.storage.add(data);
        System.out.println(data);
        return isadded;
    }
}
