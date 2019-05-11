FOI PRECISO APLICAR O CERTIFICADO SSL DO GMAIL, NA JVM, PARA CONSEGUIR ENVIAR OS E-MAILS, SEGUE TUTORIAL:

To use Gmail smtp service to send emails from your Java based mail client, you will need to import GMail smtp server's certificate into Java keystore and trust it. 


The following procedures are to import the gmail smtp certificate into the default Java keystore (Depends on the java mail application, the location of keystore may be vary): 
Connect to smtp.gmail.com:465 to display the certificate in a terminal window:

For Linux:
openssl s_client -connect smtp.gmail.com:465

For Mac OS:
openssl s_client -connect smtp.gmail.com:465

For Windows
Install openssl first (http://gnuwin32.sourceforge.net/packages/openssl.htm)

Run command:
s_client -connect smtp.gmail.com:465

Copy and save the lines between "-----BEGIN CERTIFICATE-----" and "-----END CERTIFICATE-----" into a file, say, gmail.cert:

-----BEGIN CERTIFICATE-----
MIIDWzCCAsSgAwIBAgIKFeQVggADAAA7NjANBgkqhkiG9w0BAQUFADBGMQswCQYD
VQQGEwJVUzETMBEGA1UEChMKR29vZ2xlIEluYzEiMCAGA1UEAxMZR29vZ2xlIElu
dGVybmV0IEF1dGhvcml0eTAeFw0xMTExMTgwMTU3MTdaFw0xMjExMTgwMjA3MTda
MGgxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1N
b3VudGFpbiBWaWV3MRMwEQYDVQQKEwpHb29nbGUgSW5jMRcwFQYDVQQDEw5zbXRw
LmdtYWlsLmNvbTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAuK+t5ZRq6c3K
kWPwLuIcPa6DgiBURaQK9akP4OBoXKJ6bqYIQWsS4C3RgnOaGaDENadxHSNZ5Qpl
Vqg2S54N54SM5OXwOq0NtrqdlbhgigB53TZouiJvnLDxxIexSOn2Gx1qyZF2z8Ii
MoUhHuStWgW5YoOHje8z6K9xQdYkQp0CAwEAAaOCASwwggEoMB0GA1UdDgQWBBTs
OL4jbtJ5l8B6/eoEvv30KEiTrjAfBgNVHSMEGDAWgBS/wDDr9UMRPme6npH7/Gra
42sSJDBbBgNVHR8EVDBSMFCgTqBMhkpodHRwOi8vd3d3LmdzdGF0aWMuY29tL0dv
b2dsZUludGVybmV0QXV0aG9yaXR5L0dvb2dsZUludGVybmV0QXV0aG9yaXR5LmNy
bDBmBggrBgEFBQcBAQRaMFgwVgYIKwYBBQUHMAKGSmh0dHA6Ly93d3cuZ3N0YXRp
Yy5jb20vR29vZ2xlSW50ZXJuZXRBdXRob3JpdHkvR29vZ2xlSW50ZXJuZXRBdXRo
b3JpdHkuY3J0MCEGCSsGAQQBgjcUAgQUHhIAVwBlAGIAUwBlAHIAdgBlAHIwDQYJ
KoZIhvcNAQEFBQADgYEAQiMlHuQLRFqR10UsSg5WTNe3vagbdnBLAkdhvAf90B5a
9beBxJH2/ylTSIGfD2uceAqzcsQe6Ouy4C9r3rz86qA1dhdtIcPg6uoZb+E2qhE5
UaOJOPO4rHInX9kscBxh+baHbpBMh+ch6v5L8plss8hd0id8C4g10YKzwcgPYlQ=
-----END CERTIFICATE-----

Import the certificate into java keystore(Default location):
sudo keytool -import -alias smtp.gmail.com -keystore /path/to/keystore -file /Users/wilson/gmail.cert

For Windows:
keytool -import -alias smtp.gmail.com -keystore "%JAVA_HOME%/jre/lib/security/cacerts" -file C:\Users\wilson\gmail.cert

For Mac OS:
sudo keytool -import -alias smtp.gmail.com -keystore /System/Library/Frameworks/JavaVM.framework//Versions/CurrentJDK/Home/lib/security/cacerts -file /Users/wilson/gmail.cert

For Linux:
sudo keytool -import -alias smtp.gmail.com -keystore $JAVA_HOME/jre/lib/security/cacerts -file /Users/wilson/gmail.cert

Note: your need to provide the password to access the keystore. The password for the default java keystore is changeit

Answer Yes when it ask "Trust this certificate? [no]:  yes"
Note: if your java mail client application uses its own keystore, you need to change the location of the application's keystore rather than JVM's keystore in the keytool command.

The given Gmail account settings:

If you've turned on 2-Step Verification for your account, you might need to enter an App password.
Without 2-Step Verification:

1- Allow less secure apps access to your account.
2- Visit http://www.google.com/accounts/DisplayUnlockCaptcha and sign in with your Gmail username and password.