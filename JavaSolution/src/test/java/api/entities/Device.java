package api.entities;

import api.entities.json.DeviceJSON;

public class Device {

	private String systemName;
	private String type;
	private Long hddCapacity;

	public Device() {
		super();
	}

	public Device(String systemName, String type, Long hddCapacity) {
		super();
		this.systemName = systemName;
		this.type = type;
		this.hddCapacity = hddCapacity;
	}

	public Device(DeviceJSON deviceJson) {
		super();
		this.systemName = deviceJson.getSystemName();
		this.type = deviceJson.getType();
		this.hddCapacity = deviceJson.getHddCapacity();
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getHddCapacity() {
		return hddCapacity;
	}

	public void setHddCapacity(Long hddCapacity) {
		this.hddCapacity = hddCapacity;
	}

	@Override
	public String toString() {
		return "Device [systemName=" + systemName + ", type=" + type + ", hddCapacity=" + hddCapacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hddCapacity == null) ? 0 : hddCapacity.hashCode());
		result = prime * result + ((systemName == null) ? 0 : systemName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Device other = (Device) obj;
		if (hddCapacity == null) {
			if (other.hddCapacity != null)
				return false;
		} else if (!hddCapacity.equals(other.hddCapacity))
			return false;
		if (systemName == null) {
			if (other.systemName != null)
				return false;
		} else if (!systemName.equals(other.systemName))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
