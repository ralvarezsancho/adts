package adts;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public class ExceptionInvalidIndex extends ExceptionADTs {
	
	private static final long serialVersionUID = Utilities.getSerialVersionUID();
	
	public ExceptionInvalidIndex() { super(); }
	
	public ExceptionInvalidIndex(String message) { super(message); }

}
