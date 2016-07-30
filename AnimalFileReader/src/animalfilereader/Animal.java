
package animalfilereader;
/**
 *
 * @author Greg
 */
public class Animal {
 
    private String id;
    private String name;
    private String type;
    private String age;
   
    //getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    // appending and reading 
    @Override
    public String toString(){
        return "\nID = "+getId()+" Name: "+getName()+" Type = "+getType()+" Age = "+getAge();
    }
}
