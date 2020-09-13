package local.tin.tests.model.domain.interfaces;

/**
 *
 * @author benito.darder
 */
public interface INamed extends IIdentifiable {
    
    /**
     * Returns the element name
     * 
     * @return String
     */
    public String getName();
   
    /**
     * Sets the element name
     * 
     * @param name
     */
    public void setName(String name);    
        
}
