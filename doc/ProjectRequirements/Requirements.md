# Requirements for project #
This file contains the requirements given from assignment regarding the project

---

### Der er følgende krav til systemet: ###
- Der skal være en startmenu (i tekst), hvor brugeren kan vælge mellem at
    - Oprette sig som bruger
    - Logge sig ind som bruger
- Der skal være en hovedmenu (i tekst), hvor brugeren kan vælge mellem at
    - Søge efter en bestemt film
    - Søge alle film i en kategori
    - Se sin liste over sete film
    - Se sin liste over gemte film
- Når brugeren får præsenteret en liste over alle film i en kategori, alle sete film eller alle gemte film, skal brugeren kunne vælge én af filmene
- Når brugeren har valgt en film, skal det være muligt at vælge mellem at afspille filmen (dette gøres naturligvis ikke ”rigtigt” men blot ved at skrive ”Titanic afspilles nu..” eller noget lignende), gemme filmen i sin liste over film, han eller hun ønsker at se senere eller slette filmen fra listen over film, han eller hun vil se senere. Vælger brugeren at afspille filmen, skal den gemmes i hans eller hendes liste over afspillede film.
- Brugernes login-oplysninger (brugernavn og password) skal gemmes i en fil, så de kan indlæses når programmet startes op igen.
- Der skal være fornuftig håndtering af fejl. Hvis der opstår fejl i programmet skal de håndteres passende steder og brugeren skal informeres, hvis det er relevant. Overvej hvem fejlen skal kommunikeres til. En IOException (som kan opstå, når man læser ind fra en fil) vil fx gøre, at programmet fra brugerens synspunkt ikke virker. Hvordan formidler vi til brugeren, at der er opstået en fejl?