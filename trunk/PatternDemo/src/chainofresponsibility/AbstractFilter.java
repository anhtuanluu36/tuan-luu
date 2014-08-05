/**
 * 
 */
package chainofresponsibility;

/**
 * @author TuanLA
 *
 */
public abstract class AbstractFilter {
	private AbstractFilter nextFilter;
	
	public void setNextFilter(AbstractFilter nextFilter) {
		this.nextFilter = nextFilter;
	}
	
	protected abstract String execute();
	
	public abstract boolean checkFilterEnum(SubjectEnum subjectEnum);
	
	public void filter(SubjectEnum subjectEnum, String keyword) {
		if (checkFilterEnum(subjectEnum)) {
			System.out.println(keyword + " is " + execute() + "!");
		} else {
			if (nextFilter == null) {
				System.out.println("Unidentify subject!");
				return;
			}
			nextFilter.filter(subjectEnum, keyword);
		}
	}
	
	
}
