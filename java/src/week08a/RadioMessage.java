package week08a;

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

    public int getShiftedType() {
        return (this.type << 24) & 0xFF000000;
    }

    public int getShiftedY() {
        return (this.y << 16) & 0x00FF0000;
    }

    public int getShiftedX() {
        return (this.x << 8) & 0x0000FF00;
    }

    public int getSender() {
        return this.sender & 0x000000FF;
    }

    public int toInt() {
        return getShiftedType() | getShiftedX() | getShiftedY() | getSender();
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
