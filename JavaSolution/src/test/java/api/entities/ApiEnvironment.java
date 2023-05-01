package api.entities;

public class ApiEnvironment {

	private String url;

	public ApiEnvironment(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ApiEnvironment [url=" + url + "]";
	}

}
