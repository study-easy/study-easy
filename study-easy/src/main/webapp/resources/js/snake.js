var feld_1 = "resources/images/weiss.gif";
var feld_2 = "resources/images/blau.gif";
var feld_3 = "resources/images/rot.gif";

var i_v;
var x_v;
var i_n;
var x_n;
var start_erl=1; // Nur wenn start_erl gleich 1 ist darf neugestartet werden.
var gr_wert=0; // Der am längsten besetzter Punkt;
var laenge; // L�nge der Schlange

var r1, r2; // Zufallsposition (r1--x-achse; r2--y-achse);

var Int_oben, Int_unten, Int_rechts, Int_links;
var richtung=0;

var speicher = new Array(); //Dieser Array speichert deen Zustand der Felder (Besetzt || Unbesetzt);
var Img      = new Array(); //Dieser Array ordnet zu den  Koordinaten (x-Achse; i-Achse) die entsprechende img id;

for ( i = 0; i < 15; i++ ) {
    speicher[i] = new Array();
    Img[i]      = new Array();

    for ( j = 0; j < 12; j++ ) {
        speicher[i][j] = 0;
        Img[i][j]      = "punkt" + (i+1) + '_' + (j+1);
    }
}

function start_3() {
    if( start_erl == 1 ) {
        start_erl=0; richtung=0; x_v=8; i_v=5; i_n=5; x_n=5; laenge=3;
        document.getElementById('snake_lang').innerHTML=laenge + " meter";
        zuf_punkt();
        document.getElementById(Img[6][5]).src = feld_2;
        document.getElementById(Img[7][5]).src = feld_2;
        document.getElementById(Img[8][5]).src = feld_2;
        speicher[6][5]=4; speicher[7][5]=3; speicher[8][5]=2;
        rechts_3();
    }
}

function oben_3() {
    if(richtung==1)
    {
        richtung=0;
        oben_v()
        clearInterval(Int_rechts); clearInterval(Int_links);
        Int_oben = setInterval("oben_v()", 300);
    }
}

function unten_3() {
    if(richtung==1)
    {
        richtung=0;
        unten_v();
        clearInterval(Int_rechts); clearInterval(Int_links);
        Int_unten = setInterval("unten_v()", 300);
    }
}

function rechts_3() {
    if(richtung==0)
    {
        richtung=1;
        rechts_v();
        clearInterval(Int_oben); clearInterval(Int_unten);
        Int_rechts = setInterval("rechts_v()", 300)
    }
}

function links_3() {
    if(richtung==0)
    {
        richtung=1;
        links_v();
        clearInterval(Int_oben); clearInterval(Int_unten);
        Int_links = setInterval("links_v()", 300)
    }
}

function elseZweig() {
    document.getElementById(Img[x_v][i_v]).src = feld_2;
    if(speicher[x_v][i_v]!="zufall") {
        speicher[x_v][i_v]++;
        for(a=0; a<15; a++) {
            for(b=0;b<12; b++) {
                if(speicher[a][b]>0) {
                    speicher[a][b]++;
                    if(speicher[a][b]>gr_wert) {
                        gr_wert=speicher[a][b];
                        x_n=a; i_n=b;
                    }
                }
            }
        }
        snake_weg();
    }
    else if(speicher[x_v][i_v]=="zufall") {
        speicher[x_v][i_v]=1; laenge++;
        document.getElementById('snake_lang').innerHTML = laenge + " Meter";
        for(a=0; a<15; a++) {
            for(b=0;b<12; b++) {
                if(speicher[a][b]>0) {
                    speicher[a][b]++;
                }
            }
        }
        zuf_punkt();
    }
}

function oben_v() {
    i_v--;
    if(i_v<0 || speicher[x_v][i_v]>0) {
        for(a=0; a<15; a++) {
            for(b=0;b<12; b++) {
                speicher[a][b]=0; document.getElementById(Img[a][b]).src = feld_1;
            }
        }
        start_erl=1;
        clearInterval(Int_oben);
        alert("Yuhuuu :) Deine Schlange ist " + laenge + " Meter groß geworden. Gleich nochmal!");
    } else {
        elseZweig();
    }
}

function unten_v() {
    i_v++;
    if(i_v>11 || speicher[x_v][i_v]>0) {
        for(a=0; a<15; a++) {
            for(b=0;b<12; b++) {
                speicher[a][b]=0;
                document.getElementById(Img[a][b]).src = feld_1;
            }
        }
        start_erl=1;
        clearInterval(Int_unten);
        alert("Yuhuuu :) Deine Schlange ist " + laenge + " Meter gro&szlig; geworden. Gleich nochmal!");
    } else {
        elseZweig();
    }
}

function rechts_v() {
    x_v++;
    if(x_v>14 || speicher[x_v][i_v]>0) {
        for(a=0; a<15; a++) {
            for(b=0;b<12; b++) {
                speicher[a][b]=0;
                document.getElementById(Img[a][b]).src = feld_1;
            }
        }
        start_erl=1;
        clearInterval(Int_rechts);
        alert("Yuhuuu :) Deine Schlange ist " + laenge + " Meter gro&szlig; geworden. Gleich nochmal!");
    } else {
        elseZweig();
    }
}

function links_v() {
    x_v--;
    if(x_v<0 || speicher[x_v][i_v]>0) {
        for(a=0; a<15; a++) {
            for(b=0;b<12; b++) {
                speicher[a][b]=0;
                document.getElementById(Img[a][b]).src = feld_1;
            }
        }
        start_erl=1;
        clearInterval(Int_links);
        alert("Yuhuuu :) Deine Schlange ist " + laenge + " Meter gro&szlig; geworden. Gleich nochmal!");
    } else {
        elseZweig();
    }
}



function zuf_punkt() {
    r1 = Math.round(Math.random()*15-0.5); r2 = Math.round(Math.random()*12-0.5);
    if(speicher[r1][r2]==0) {
        document.getElementById(Img[r1][r2]).src = feld_3;
        speicher[r1][r2]="zufall";
    } else if(speicher[r1][r2]!=0) {
        zuf_punkt();
    }
}

function snake_weg() {
    document.getElementById(Img[x_n][i_n]).src = feld_1;
    speicher[x_n][i_n]=0;
    gr_wert=0;
}

function initSnake() {
    document.write('<div style="position: relative;">');
    for ( i = 1; i <= 15; i++ ) {
        for ( j = 1; j <= 12; j++ ) {
            document.write('<div style="position:absolute; top:' + (20+(j*20)) + 'px; left:' + (i*20) + 'px; border: 1px dashed #979797;"><img id="punkt' + i + '_' + j + '" src="' + feld_1 + '" alt="" /></div>');
        }
    }
    document.write('</div>');
    // default-schlange:
    document.getElementById('punkt7_6').src = feld_2;
    document.getElementById('punkt8_6').src = feld_2;
    document.getElementById('punkt9_6').src = feld_2;
}
//-->