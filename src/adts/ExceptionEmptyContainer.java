package adts;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public class ExceptionEmptyContainer extends ExceptionADTs {
	
	private static final long serialVersionUID = Utilities.getSerialVersionUID();
	
	public ExceptionEmptyContainer() { super(); }
	
	public ExceptionEmptyContainer(String msg) { super(msg); }

}
