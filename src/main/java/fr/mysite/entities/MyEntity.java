package fr.mysite.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Base class for all entities. Used to factor the id and version fields.
 * Implements {@link Serializable}
 * 
 * @author Jason POQUET
 *
 */
@MappedSuperclass
public class MyEntity implements Serializable {

    /**
     * Used during deserialization to check compatibility.
     * 
     * @see {@link Serializable}
     * @see <a href=
     *      "https://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it">Discussion
     *      on why it's important</a>
     */
    private static final long serialVersionUID = 1L;
    

    /**
     * The id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    
    /**
     * The version
     */
    @Version
    protected int version;
    
    /**
     * The id getter
     * 
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * The id setter
     * 
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * The version getter
     * 
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * The version setter
     * 
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }
    
    
    
    
}
