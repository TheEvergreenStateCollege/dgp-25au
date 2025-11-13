package teacher07b;

public class RadioMessage {

    byte type;
    byte x;
    byte y;
    byte sender;
    
    public RadioMessage(byte type, int x, int y, int sender) {
        this.type = type;
        this.x = (byte)(x & 0xFF);
        this.y = (byte)(y & 0xFF);
        this.sender = (byte)(sender & 0xFF);
    }

    public int toInt() {
        return (this.type << 24) | (this.y << 16) | (this.x << 8) | (this.sender);
    }

    public static RadioMessage fromInt(int message) {
        byte type = (byte)((message >> 24) & 0xFF);
        byte y = (byte)((message >> 16) & 0xFF);
        byte x = (byte)((message >> 8) & 0xFF);
        byte sender = (byte)(message & 0xFF);
        return new RadioMessage(type, x, y, sender);
    }

    public String toString() {
        return "Radio Message" + " type: " + this.type + " x: " + this.x + " y: " + this.y + " sender: " + this.sender;
    }
}
