package tr.com.sedatpolat.stringset.output;

import java.io.Serializable;

import tr.com.sedatpolat.stringset.constants.MessageConstants;

/**
 * 
 * @author sedpol
 *
 */
public class BaseOutput implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Boolean success;
	private String message;
	
	public BaseOutput() {
	}
	
	public BaseOutput(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public void markedAsSuccess() {
		this.success = true;
		this.message = MessageConstants.SUCCESS;
	}
	
	public void markedAsFailed() {
		this.success = false;
		this.message = MessageConstants.FAILED;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
