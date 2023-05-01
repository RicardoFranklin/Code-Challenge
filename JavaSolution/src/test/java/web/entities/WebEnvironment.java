package web.entities;

public class WebEnvironment {

	private String url;
	private String remoteServerUrl;
	private Integer implicityTimeout;
	private Integer explicityTimeout;
	private Integer explicityAttemptTime;

	public WebEnvironment(String url, String remoteServerUrl, Integer implicityTimeout, Integer explicityTimeout,
			Integer explicityAttemptTime) {
		super();
		this.url = url;
		this.remoteServerUrl = remoteServerUrl;
		this.implicityTimeout = implicityTimeout;
		this.explicityTimeout = explicityTimeout;
		this.explicityAttemptTime = explicityAttemptTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getImplicityTimeout() {
		return implicityTimeout;
	}

	public void setImplicityTimeout(Integer implicityTimeout) {
		this.implicityTimeout = implicityTimeout;
	}

	public Integer getExplicityTimeout() {
		return explicityTimeout;
	}

	public void setExplicityTimeout(Integer explicityTimeout) {
		this.explicityTimeout = explicityTimeout;
	}

	public Integer getExplicityAttemptTime() {
		return explicityAttemptTime;
	}

	public void setExplicityAttemptTime(Integer explicityAttemptTime) {
		this.explicityAttemptTime = explicityAttemptTime;
	}

	public String getRemoveServerUrl() {
		return remoteServerUrl;
	}

	public void setRemoveServerUrl(String removeServerUrl) {
		this.remoteServerUrl = removeServerUrl;
	}

	@Override
	public String toString() {
		return "WebEnvironment [url=" + url + ", remoteServerUrl=" + remoteServerUrl + ", implicityTimeout="
				+ implicityTimeout + ", explicityTimeout=" + explicityTimeout + ", explicityAttemptTime="
				+ explicityAttemptTime + "]";
	}

}
