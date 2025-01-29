# Preguntes teòriques

**1. Per què s’atura l’execució al cap d’un temps?**
L’execució s’atura perquè els fils acaben executant totes les accions possibles (reserves i cancel·lacions) i arriva un punt on es queden bloquejats en un wait esperant una acció que no arriba mai.

**2. Què passaria si canviéssim la probabilitat de fer una reserva a 70% i la de cancel·lar a 30%? I si ho féssim a la inversa?**

- Si augmentem la probabilitat de fer una reserva (70%) i reduïm la de cancel·lació (30%), és més probable que les places s’omplin ràpidament i es mantinguin sense espai disponible durant més temps.
- Si la probabilitat és al revés (30% reserves i 70% cancel·lacions), les reserves es cancel·larien més sovint i difícilment arribaria a omplir-se el màxim de places.

**3. Per què creus que fa falta la llista i no valdria només una variable sencera de reserves?**
La llista és necessària per gestionar quins assistents han fet una reserva i permetre la cancel·lació. Si només es fes servir una variable sencera per comptar reserves, no es podria saber quin assistent ha fet la reserva i, per tant, no es podria gestionar correctament la cancel·lació.
