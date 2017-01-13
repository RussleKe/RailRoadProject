/**
 * Created by RuslanKuleshov on 13.01.17.
 */
public class BaseEntity {

    private Long id;


    public BaseEntity(){

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public boolean isNew(){
        return(this.id == null);

    }
}
