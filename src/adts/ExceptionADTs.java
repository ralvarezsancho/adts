package adts;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public class ExceptionADTs extends RuntimeException {
	
	private static final long serialVersionUID = Utilities.getSerialVersionUID();
	
	public ExceptionADTs() { super(); }
	
	public ExceptionADTs(String message) { super(message); }

}
