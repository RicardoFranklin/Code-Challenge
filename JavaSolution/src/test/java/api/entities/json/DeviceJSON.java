package api.entities.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceJSON {
		
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("system_name")
	private String systemName;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("hdd_capacity")
	private Long hddCapacity;	
	
	public DeviceJSON() {
		super();
	}
	
	public DeviceJSON(String id, String systemName, String type, Long hddCapacity) {
		super();
		this.id = id;
		this.systemName = systemName;
		this.type = type;
		this.hddCapacity = hddCapacity;
	}
	
	@Override
	public String toString() {
		return "DeviceJSON [id=" + id + ", systemName=" + systemName + ", type=" + type + ", hddCapacity="
				+ hddCapacity + "]";
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}
	
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("system_name")
	public String getSystemName() {
		return systemName;
	}

	@JsonProperty("system_name")
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType (String type) {
		this.type = type;
	}

	@JsonProperty("hdd_capacity")
	public Long getHddCapacity() {
		return hddCapacity;
	}

	@JsonProperty("hdd_capacity")
	public void setHddCapacity(Long hddCapacity) {
		this.hddCapacity = hddCapacity;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((hddCapacity == null) ? 0 : hddCapacity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((systemName == null) ? 0 : systemName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceJSON other = (DeviceJSON) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (hddCapacity == null) {
			if (other.hddCapacity != null)
				return false;
		} else if (!hddCapacity.equals(other.hddCapacity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (systemName == null) {
			if (other.systemName != null)
				return false;
		} else if (!systemName.equals(other.systemName))
			return false;
		return true;
	}

}
