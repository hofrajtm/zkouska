# Program pro převod čísla z arabských číslic na římské a zpět

## Římské číslice

Jedná se o způsob zápisu čísel pomocí vybraných písmen latinské abecedy. Důležitou charakteristikou římských číslic je skutečnost,
že hodnota číslice je daná jejím symbolem a nezávisí na její pozici v zapsaném čísle. Nezávislost na poloze však není neomezená, viz
kapitola **Pravidla zápisu**.
Římské číslice se v současné době používají především pro označování kapitol, odstavců, roků, století, měsíců, atd., pro zápis čísel se
však využívají především arabské číslice.

### Základní symboly

Základní římské číslice jsou vyjadřovány symboly:
- **I** = 1, symbolizující jeden vztyčený prst
- **V** = 5, symbolizující dlaň s pěti prsty, kde 'V' tvoří tvar mezi palcem a malíčkem
- **X** = 10, symbolizující analogicky dvě dlaně s pěti prsty u sebe
- **L** = 50, původem je vodorovné rozpůlení symbolu vyjadřujícího stovku, které připomíná 'L'
- **C** = 100, původem je latinský výraz pro stovku (centum, odtud 'C')
- **D** = 500, původem je svislé rozpůlení symbolu vyjadřujícího tisíc, které připomíná 'D'
- **M** = 1000, původem je latinský výraz pro tisíc (mille, odtud 'M')

### Pravidla zápisu

Pro převod arabských čísel na římská a naopak neexistuje žádná směrodatná norma. Rozhodujícími faktory pro zápis tak jsou vesměs
obecně uznávané zvyklosti, které vznikaly v průběhu 16. - 18. století.

**Pro číslo zapsané římskými číslicemi platí:**

1. Zapisuje se kombinací symbolů I, V, X, L, C, D, M.
2. Zapisuje se zleva doprava od symbolu s nejvyšší hodnotou k symbolu s nejnižší hodnotou, výjimka viz **Pravidlo č. 3**.
3. Obsahuje nejvýše jeden symbol nižší hodnoty před symbolem vyšší hodnoty, přičemž to mohou být pouze symboly I, X, C v případech
*IV = 4*, *IX = 9*, *XL = 40*, *XC = 90*, *CD = 400*, *CM = 900*.
4. Obsahuje nejvýše tři stejné symboly za sebou, přičemž to mohou být pouze symboly M, C, X a I v případech *MMM = 3000*, *CCC = 300*,
*XXX = 30* a *III = 3*. Výjimkou však byla například kombinace *IIII = 4* na starých slunečních hodinách.
5. Obsahuje nejvýše čtyři stejné symboly, přičemž to mohou být pouze symboly M, C a X v případech *MMMCM = 3900*, *CCCXC = 390* a
*XXXIX = 39*.

**!** Číslo zapsané římskými číslicemi nabývá hodnot pouze v intervalu celých čísel od 1 do 3999. **!**

Zajímavostí je, že římské číslice neobsahují symbol pro nulu. Právě absence tohoto symbolu zamezila postupné přeměně římského zápisu
na poziční systém\*, a proto byl během 11. století v praktickém životě a v matematice nahrazen arabskými číslicemi.

\* Poziční číselná soustava je způsob písemné reprezentace čísel, ve kterém není hodnota číslice dána jejím umístěním v dané sekvenci
číslic, např. arabské číslice. Opakem je nepoziční číselná soustava, např. římské číslice.

## Program

Program slouží pro převod čísla zapsaného arabskými číslicemi na číslo zapsané římskými číslicemi a naopak.

### Funkce programu

Program je interaktivní:

- Nejprve probíha převod čísla zapsaného arabskými číslicemi na číslo zapsané římskými číslicemi, přičemž je uživatel požádán o zadání
vstupního čísla. Po stisknutí klávesy Enter se zobrazí výsledek. Tato část programu se opakuje do té doby, dokud uživatel nezadá a
nepotvrdí jako vstupní číslo '0'. - Zadáním vstupního čísla '0' se program posune dál a probíhá převod čísla zapsaného římskými
číslicemi na číslo zapsané arabskými číslicemi, přičemž je uživatel požádán o zadání vstupního čísla. Po stisknutí klávesy Enter
se zobrazí výsledek. Tato část programu se opakuje do té doby, dokud uživatel nezadá a nepotvrdí jako vstupní číslo '0'. Tímto příkazem
je celý program ukončen.

V případě, že nejsou dodržena pravidla, viz kapitola **Pravidla zápisu**, program vypíše typ chyby a je ukončen.

### Struktura programu

#### Jak pracuje algoritmus

Program je rozdělen na dvě části:

1. Převod čísla zapsaného arabskými číslicemi na číslo zapsané římskými číslicemi

   - Načtení vstupního čísla zadaného uživatelem ve formě *integer*. Metoda **readInt()**.
   - Převedení vstupní hodnoty z datového typu *integer* na *string* (řetězec). Metoda **valueOf()**.
   - Zrcadlové otočení *stringu* (řetězce), respektive převrácení pořadí všech znaků, které obsahuje. Metoda **reverse().toString()**.
   - Převedení tohoto *string* (řetězce) na *array* (pole). Metoda **toCharArray()**.
   - Dotázání na počet znaků v *array (poli)* a na základě této informace se vždy aplikuje jedna z metod **radJednotek()**,
     **radDesitek()**, **radStovek()**, **radTisicu()**. Metody vytváří *string* (řetězce), které odpovídají symbolům v římských
     číslech na základě jejich pozice uvnitř čísla.
   - Spojení *stringů* (řetězců) až při tisknutí výstupu.
   - Ukončení této části programu v případě, že uživatel zadá jako vstupní číslo '0'.

2. Převod čísla zapsaného římskými číslicemi na číslo zapsané arabskými číslicemi

   - Načtení vstupního čísla zadaného uživatelem ve formě *string*. Metoda **readString()**.
   - Převedení vstupní hodnoty z datového typu *string* (řetězec) na *array* (pole). Metoda **toCharArray()**.
   - Kontrola jednotlivých prvků pole, zda neobsahují znaky, které nejsou přípustné.
   - Rozdělení na dvě větve, kdy jedna pracuje pouze tehdy, je-li počet prvků pole roven jedné a druhá pouze tehdy, je-li počet prvků
     pole větší než jedna. Ošetření aplikováno z toho důvodu, že v druhé větvi program pracuje s cyklem *for*, který který není u pole
     o jednom prvku nutný. 
   - První větev okamžitě přisoudí znaku v poli hodnotu arabské číslice.
   - Druhá větev dále předefinuje hodnoty všech prvků na arabské číslice, tak aby bylo následně možné porovnání jejich hodnot,
     tj. <, > či = .
   - Další kontroly správnosti zadaného vstupního čísla, mezi které patří podmínky, aby zapsané číslo odpovídalo pravidlům uspořádání
     římských číslic, které jsou sepsány v kapitole **Pravidla zápisu**.
   - Souběžné přičítání/odčítání odpovídající hodnoty k/od výsledného čísla (na základě porovnání hodnoty i-tého a následujícího znaku)
     vyjádřeného arabskými číslicemi. Prvek s menší hodnotou předcházející prvku s větší hodnotou má vždy záporné znaménko. Poslední
     prvek je vždy pouze přičten a to samostatně.
   - Ukončení celého programu v případě, že uživatel zadá jako vstupní číslo '0'.

#### Problematická místa 

Problematickými místy při zpracování programu byly především správné definice podmínek, za kterých se vstupní data měla odmítnout
a program měl vypsat chybu. Zároveň není zcela jasné, z kterých zdrojů by měl člověk při definování pravidel pro zápis římských čísel
vycházet. Některé informace se liší a občas se jeví jako nelogické, např. uspořádání symbolů, jejich maximální počet, atd.

#### Možná vylepšení vzhledem k existujícím algoritmům 

Existují nejrůznější algoritmy pro převod římských číslic na arabské a zpět, a to nejen v Javě, ale i Pythonu, C++ a dalších. Většina
z nich pro převod arabských číslic na římské aplikuje rozklad vstupního čísla na nejmenší počet čísel odpovídajících hodnotám římských
číslic, ze kterých je poté výstupní číslo po převodu složeno. Výhodou oproti mému zápisu je úspora místa, a tím i času. Při druhém
typu převodu číslic se uplatňují především již sestavené funkce a metody.
