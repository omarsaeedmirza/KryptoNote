package e.omirza.kryptonote;


public class Cipher
{
    public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789#%";
    private String key;

    public Cipher(String k)
    {
            this.key = k;

    }

    public String encryptRSA(String note){
        String result = "";
        int prime1 = 61;
        int prime2 = 53;
        int keyMult = prime1 * prime2; //used as public and private key
        int totient = (prime1 - 1) * (prime2 - 1); //3120
        int coprime = 17; //public key exponent
        int congRel = 2753;  //private key exponent
        return result;
    }

    private String makePad(String note)
    {
        String pad = this.key;

        while(pad.length() < note.length())
        {
            pad += this.key;
        }

        return pad;
    }

    public String encrypt(String note)
    {
        String pad = makePad(note);
        String result = "";

        for(int i = 0; i < note.length(); i++)
        {
            String c = note.substring(i, i + 1);
            int position = ALPHABET.indexOf(c);
            int shift = pad.charAt(i);
            int newPosition = (position + shift) % ALPHABET.length();
            result = result + ALPHABET.substring(newPosition, newPosition + 1);
        }
        return result;
    }

    public String decrypt(String note)
    {
        String pad = makePad(note);
        String result = "";

        for(int i = 0; i < note.length(); i++)
        {
            String c = note.substring(i, i + 1);
            int position = ALPHABET.indexOf(c);
            int shift = pad.charAt(i);
            int newPosition = position - shift;
            while (newPosition < 0){
                newPosition += ALPHABET.length();
            }
            newPosition %= ALPHABET.length();
            result = result + ALPHABET.substring(newPosition, newPosition + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Cipher cipher = new Cipher("ABCD#$");
        String test = "This is a test of a longer test case with possible pseudo 64 bit encryption using punctuation such as #%";
        String encrypt = cipher.encrypt(test);
        System.out.println(encrypt);
        System.out.println(cipher.decrypt(encrypt));
    }
}
