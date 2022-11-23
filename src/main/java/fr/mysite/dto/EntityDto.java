package fr.mysite.dto;

import java.io.Serializable;

public abstract class EntityDto implements Serializable {

    /**
     * Used during deserialization to check compatibility.
     * 
     * @see {@link Serializable}
     * @see <a href=
     *      "https://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it">Discussion
     *      on why it's important</a>
     */
    private static final long serialVersionUID = -4037913583790492796L;

    /**
     * The id
     */
    protected long id;

    /**
     * The version
     */
    protected int version;

    /**
     * No-args constructor
     */
    protected EntityDto() {
        super();
    }

    /**
     * Constructor
     * 
     * @param id      the id
     * @param version the version
     */
    protected EntityDto(long id, int version) {
        super();
        this.id = id;
        this.version = version;
    }

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
