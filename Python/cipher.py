class CaesarCipher:
    """Class for doing encryption and decryption using a Caesar cipher."""

    def __init__(self, shift):
        """Construct Carsar cipher using given integer shift for rotation."""
        self._forward = ''.join([chr((i + shift) % 26 + ord('A')) for i in range(26)])
        self._backward = ''.join([chr((i - shift) % 26 + ord('A')) for i in range(26)])
    
    def encrypt(self, message):
        """Returns a string representing encripted message."""
        return self._transform(message, self._forward)
    
    def decrypt(self, secret):
        """Returns a decrypted message given encrypted secret."""
        return self._transform(secret, self._backward)
    
    def _transform(self, original, code):
        """Utility to perform transformation based on given code string."""
        msg = list(original)
        for i in range(len(msg)):
            if msg[i].isupper():
                j = ord(msg[i]) - ord('A')
                msg[i] = code[j]
        return ''.join(msg)

if __name__ == '__main__':
    cipher = CaesarCipher(3)
    message = "THE EAGLE IS IN PLAY; MEET AT NUMBANI."
    coded = cipher.encrypt(message)
    print('Secret: ', coded)
    answer = cipher.decrypt(coded)
    print('Message: ', answer)
