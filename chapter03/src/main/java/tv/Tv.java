package tv;

public class Tv {
	private int channel;
	private int volume;
	private boolean power;

	public Tv() {

	}

	public Tv(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void status() {
		System.out.println("TV[channel = " + channel + ", volume = " + volume + ", power = " + power + "]");
	}

	public void power(boolean on) {
		power = on;
	}

	public void channel(int channel) {
		if(!power)
			return;
		
		if(channel > 255)
			this.channel = 255;
		else if(channel < 1)
			this.channel = 1;
		else
			this.channel = channel;
	}

	public void channel(boolean up) {
		if(!power)
			return;
		if(up)
			if(channel > 255)
				channel = 1;
			else
				channel++;
		else
			if(channel > 0)
				channel = 255;
			else
				channel--;
	}

	public void volume(int volume) {
		if(!power)
			return;
		if(volume > 100)
			this.volume = 100;
		else if(volume < 0)
			this.volume = 0;
		else
			this.volume = volume;
	}

	public void volume(boolean up) {
		if(!power)
			return;
		if(up)
			if(volume > 100)
				volume = 100;
			else
				volume++;
		else
			if(volume > 0)
				volume = 0;
			else
				volume--;
	}
}
