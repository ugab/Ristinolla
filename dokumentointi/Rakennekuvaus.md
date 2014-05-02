Pää luokka App kutsuu luokkaa AloitusMenu joka taas kutsuu sekä luokkaa 
Ruudukko että Pelaaja. Kun AloitusMenu kutsuu Ruudukkoa se antaa sille 
parametreina kaksi pelaaja-oliota. Aloitusmenu voi kutsua Ruudukkoa 
rajattoman monta kertaa. 

Ruudukko luo uudet Vuoro ja Lauta oliot heti konstruktorissa. Sekä 
vuoro että lauta annetaan parametrinä jokaiselle Ruutu oliolle joka luodaan.
Ruutu oliot muodostavat varsinaisen peliruudukon jolla käyttäjät pelaavat
itse peliä ja niitä luodaan jokaiselle peliruudukon ruudulle yksi.

Ruutu käyttää oliota lauta kun sitä painetaan jolloin se merkitsee lauta
oliossa olevaan taulukkoon joko 1 tai 2 riippuen siitä kumman vuoro on mikä taas
selviää vuoro oliosta.

Lauta pitää kirjaa kaikista tähän asti tehdyistä merkinnöistä ja tarkistaa jokaisen 
merkinnän jälkeen että onko voittoehto täyttynyt, jos on niin toinen pelaaja olioista 
merkitään voittajaksi.

Pelaaja ja vuoro ovat kummatkin hyvin yksinkertaisia. Pelaaja pitää sisällään pelaajan nimen
ja sen onko hän voittanut. Vuoro pitää kirjaa siitä kumman vuoro on.