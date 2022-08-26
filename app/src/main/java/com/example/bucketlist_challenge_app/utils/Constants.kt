package com.example.bucketlist_challenge_app.utils

import android.content.res.Resources
import android.net.Uri
import com.example.bucketlist_challenge_app.R
import com.example.bucketlist_challenge_app.models.BucketlistEntryModel

object Constants {

    val mrAndMrsHummus = BucketlistEntryModel(
        0,
        "Mr and Mrs Hummus",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.mrmrshummus)
            .toString(),
        "Hier bekommt ihr die besten Falafel in Bonn, nein wahrscheinlich in ganz NRW! Eine ganz klare Bestellempfehlung sind die Falafeln, Babaganoush und Shakshuka. Aber aufpassen, das Ganze ist ziemlich mächtig. Sollte man auch bei der Pita-Bestellung mit einkalkulieren.",
        "26.08.2022",
        "Kaiser-Karl-Ring 27, 53111 Bonn",
        0.0,
        0.0
    )

    val cafeBrooks = BucketlistEntryModel(
        0,
        "Café Brooks",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.cafebrooks)
            .toString(),
        "Mujus Lieblingscafé für einen ausgiebigen Sonntagsbrunch! Nach vorheriger Reservierung (frühzeitig notwendig!) kann man hier am Buffett schlemmen, was das Zeug hält. Es gibt Bio- und Fairtrade Produkte und eine wechselnde Auswahl. Die warmen, buttrigen Croissants sollte man sich nicht entgehen lassen!",
        "26.08.2022",
        "Hasselbrookstraße 37, 22089 Hamburg",
        0.0,
        0.0
    )

    val standUpPaddelnAlster = BucketlistEntryModel(
        0,
        "Stand-Up Paddling auf der Alster",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.aussenalster)
            .toString(),
        "An einem schönen Sommertag einmal durch ganz Hamburg paddlen, ein Must-Do für jeden Hamburger! Alle Kanäle münden in der Alster, weshalb man fast jeden Bezirk Hamburgs einmal von dort aus erleben kann, inkl. des Stadtparks. Es lohnt sich in diesem Zuge auch einmal beim Café Canale vorbeizuschauen, dort kann man sich vom Wasser aus seinen Kaffee direkt aufs SUP bestellen, yummy!",
        "26.08.2022",
        "20148 Hamburg",
        0.0,
        0.0
    )

    val pizzaBeiUeberquell = BucketlistEntryModel(
        0,
        "Pizza bei Überquell",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.ueberquell)
            .toString(),
        "Überquell macht nicht nur einige Biere, sondern auch eine fantastische Pizza! Im hippen Hof des Restaurants werden neapolitanische Pizzen gezaubert, ein Gaumenschmaus sind insbesondere die saisonal wechselnden Pizzen mit Kürbis, Hummus oder Roter Beete. Anschließend lohnt sich ein Besuch im Park Fiction oberhalb des Restaurants, wo man den Dampfern beim Schippern in den Sonnenuntergang zusehen kann.",
        "26.08.2022",
        "St. Pauli Fischmarkt 28-32, 20359 Hamburg",
        0.0,
        0.0
    )

    val radTourAnDerDoveElbe = BucketlistEntryModel(
        0,
        "Radtour an der Dove-Elbe",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.doveelbe)
            .toString(),
        "Eine Radtour, die ist lustig, eine Radtour die ist schön! Die Dove-Elbe ist ein wahrliches Naherholungsgebiet, wie es im Buche steht. Startet man an der Elbe nach Osten, ist man in wenigen Kilometern schon in der puren Natur. Besonders cool ist es, dass man hier auch schwimmen kann, da nur kleine Boote oder Ruderboote zugelassen sind. Lohnt sich an einem schönen sonnigen Sonntag!",
        "26.08.2022",
        "Hamburg",
        0.0,
        0.0
    )

    val wiesbaden = BucketlistEntryModel(
        0,
        "Wiesbaden",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.wiesbaden)
            .toString(),
        "Wiesbaden, Severins Neuentdeckung des Jahres 2022! Ob zum Wilhelmsstraßenfest oder einfach für einen gemütlichen Samstagsausflug, Wiesbaden ist definitiv eine Reise wert. Es gibt nicht nur einen großen Kurpark, sondern auch ein Schloss, das besucht werden will!",
        "26.08.2022",
        "Wiesbaden",
        0.0,
        0.0
    )

    val miniaturWunderland = BucketlistEntryModel(
        0,
        "Miniatur Wunderland",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.miniatur)
            .toString(),
        "Das Miniatur Wunderland ist ein Paradies für Groß und Klein. Hier gibt es die größte Modelleisenbahn der Welt. In verschiedenen Themenwelten wurden 16.138 Meter Gleise verlegt, auf denen 1.120 Züge fahren. Fühlt sich fast so an wie mit Papa an Weihnachten, wenn wir die Eisenbahn aufgebaut haben!",
        "26.08.2022",
        "Kehrwieder 2/Block D, 20457 Hamburg",
        0.0,
        0.0
    )

    val mecklenburgischeSeenplatte = BucketlistEntryModel(
        0,
        "Mecklenburgische Seenplatte",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.mecklenburgische_seenplatte)
            .toString(),
        "Die Mecklenburgische Seenplatte hat besonders in Corona-Jahren an großer Beliebtheit dazugewonnen. Durch die Vielzahl an Seen, die nahezu alle miteinander verbunden sind, ist sie ein Paradies für Wassersportler. Besonders beliebt: eine Kanu/Kayaktour oder ein Aufenthalt auf einem Hausboot, mit dem man über die Seen schippern kann. Aber natürlich kann man auch an Land wunderbar Fahrrad fahren und die Natur erkunden!",
        "26.08.2022",
        "Mecklenburg-Vorpommern",
        0.0,
        0.0
    )

    val koenigsse = BucketlistEntryModel(
        0,
        "Königssee",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.koenigssee)
            .toString(),
        "Der Königssee wird als schönster See Deutschlands betitelt. Gelegen im Berchtesgadener Land versprüht er bayrischen Charme. Die Alpenkuilsse und die Kirche St. Bartholomä machen eine Schifffahrt über den See zu einem besonderen Ereignis. Kleiner Tipp: wenn man sich schon einmal auf den Weg gemacht hat, lohnt sich auch ein Abstecher ins schöne Salzburg.",
        "26.08.2022",
        "83471 Schönau am Königssee",
        0.0,
        0.0
    )

    val hohesVenn = BucketlistEntryModel(
        0,
        "Hohes Venn",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.hohesvenn)
            .toString(),
        "Das hohe Venn, ein Naturspektakel, das sich über Deutschland und Belgien erstreckt. Vor 10.000 Jahren bildete sich hier ein Hochmoor, das bis heute sein urzeitliches Flair versprüht. Das Naturschutzgebiet eignet sich wunderbar für einen Spaziergang und einen Kaffee in den anliegenden, süßen Venndörfern.",
        "26.08.2022",
        "4960 Malmedy, Belgien",
        0.0,
        0.0
    )

    val urlaubInSuedtirol = BucketlistEntryModel(
        0,
        "Urlaub in Südtirol",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.bergwandern_suedtirol)
            .toString(),
        "Urlaub in Südtirol – welch eine Wohltat. Eingerahmt in die Alpen liegt Südtirol mit seinen Obstplantagen und kleinen Dörfern im Norden Italiens. Es eignet sich hervorragend zum Wandern, Spazieren, Städtetrips und Wein trinken. Besonders empfehlen wir eine Reise im September, dann ist es nicht so heiß und die Weinlese steht vor der Tür – es gibt also genug Möglichkeiten auch mal von der Rebe zu naschen!",
        "26.08.2022",
        "Südtirol",
        0.0,
        0.0
    )

    val fahrradFahrenRursee = BucketlistEntryModel(
        0,
        "Fahrradfahren um den Rursee",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.rursee)
            .toString(),
        "Rursee – Leben in Echtzeit. Mit diesem catchy Slogan wirbt der Rursee für einen Besuch in der schönen Eifel. Ob mit dem Rad, zu Fuß oder mit dem Boot: der See hat einiges an Freizeitangebot zu bieten. Nur ein paar Kilometer von Euskirchen entfernt ist er sowohl mit Auto, als auch mit Zug & Rad gut zu erreichen!",
        "26.08.2022",
        "52396 Heimbach",
        0.0,
        0.0
    )

    val pfannkuchenmuehle = BucketlistEntryModel(
        0,
        "Pfannkuchenmühle in Neunkirchen-Seelscheid",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.pfannkuchen)
            .toString(),
        "Pfannekuchen for the win! Eine Legende aus Severins Kindheit. Die Pfannkuchenmühle weckt nicht nur warme Erinnerungen an Essen gehen mit Oma, sondern liefert neben teigigen Gerichten für den süßen Zahn auch herzhafte Varianten des Pfannen-Klassikers!",
        "26.08.2022",
        "Bröltalstraße 5, 53819 Neunkirchen-Seelscheid",
        0.0,
        0.0
    )

    val minigolfInDerRheinaue = BucketlistEntryModel(
        0,
        "Minigolf in der Bonner Rheinaue",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.adventure_golf_die_rheinpiraten_bonn_42)
            .toString(),
        "Ein neuer Minigolf-Platz für die Bonner Rheinaue. Die Rheinpiraten versprechen Spaß auf 18 spannenden Minigolf-Bahnen, spektakuläre Hindernisse und Urlaubsfeeling am Sandstrand. Ich verlange eine Revanche zur letzten Runde!",
        "26.08.2022",
        "Herbert-Wehner-Platz, 53175 Bonn",
        0.0,
        0.0
    )

    val wahnbachtalsperre = BucketlistEntryModel(
        0,
        "Wahnbachtalsperre",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.wahnbach)
            .toString(),
        "Die Wahnbachtalsperre fungiert nicht nur als Trinkwasserversorgung für Bonn, sondern lädt auch zu einem ausgiebigen Spaziergang mit Hund ein! Sie bietet eine wunderbare Abwechslung zwischen Wald und Wiesenlandschaften, Bachtälern und kleinen Ortschaften. Und nicht zu vergessen der wunderbare Blick auf den See!",
        "26.08.2022",
        "53721 Siegburg",
        0.0,
        0.0
    )

    val heidelberg = BucketlistEntryModel(
        0,
        "Heidelberg",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.heidelberg)
            .toString(),
        "Heidelberg am Neckar – ein Deutschland wie aus dem Bilderbuch. Nicht nur für die Weinkultur (hier gibt es ein wunderbares Weinfest), sondern auch für das Schloss, das über der Stadt thront, ist Heidelberg bekannt. In der malerischen Altstadt kann man wunderbar die Seele baumeln lassen.",
        "26.08.2022",
        "Heidelberg",
        0.0,
        0.0
    )

    val kottenforst = BucketlistEntryModel(
        0,
        "Kottenforst",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.aussenalster)
            .toString(),
        "Mit 40km² Fläche bietet der Kottenforst ein wunderbares Naherholungsgebiet für ausgiebige Spaziergänge in Bonner Stadtnähe. Nicht nur ist es möglich, über den Venusberg einige Höhenmeter zu erklimmen, sondern auch in der Waldau Wildtiere zu sehen. Ein Vergnügen für Groß und Klein.",
        "26.08.2022",
        "Endenicher Str. 299, 53121 Bonn",
        0.0,
        0.0
    )

    val biancchi = BucketlistEntryModel(
        0,
        "Eiscafé Biancchi",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.bianchi)
            .toString(),
        "DAS BESTE EIS BONNS! Das behaupten jedenfalls Mythen aus dem Hause Brochhagen. Bei einem Besuch in der Höhle Brochhagen/Schäfer empfiehlt sich ein Besuch im Eiscafé, um diesen Mythos zu überprüfen. Der Gastgeber empfiehlt auf Nachfrage auch seine Lieblingssorte. Guten Appetit!",
        "26.08.2022",
        "Annaberger Str. 159A, 53175 Bonn",
        0.0,
        0.0
    )

    val wahnerHeide = BucketlistEntryModel(
        0,
        "Wahner Heide",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.wahnerheide)
            .toString(),
        "Die Wahner Heide ist das artenreichste Naturschutzgebiet in NRW. Gelegen zwischen Köln-Porz, Rösrath, Troisdorf und Lohmar bietet sie zahlreiche Möglichkeiten für Wanderungen über die Heide, am Fluss entlang oder im Wald. Hier bieten Tümpel eine mystische Atmosphäre! Kleiner Tipp: besonders schön ist die Heide zur Blütezeit im August und September.",
        "26.08.2022",
        "Kammerbroich 67, 51503 Rösrath",
        0.0,
        0.0
    )

    val zecheZollverein = BucketlistEntryModel(
        0,
        "Zeche Zollverein",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.zechezollverein)
            .toString(),
        "Das UNESCO-Welterbe Zeche Zollverein wird als „schönste Zeche der Welt“ bezeichnet. Mithilfe verschiedener Ausstellungen und Führungen kann man die einst größte und leistungsstärkste Steinkohlezeche der Welt erleben und einiges über die bewegende Industriegeschichte lernen. Kleiner Tipp vom Kenner: Das „Red Dot Design“ Museum nebenan zeigt vom Smartphone bis zum multifunktionalem Küchengerät Designklassiker der letzten Jahre!",
        "26.08.2022",
        "Gelsenkirchener Str. 181, 45309 Essen",
        0.0,
        0.0
    )

    val bobergerDuenen = BucketlistEntryModel(
        0,
        "Boberger Dünen",
        Uri.parse("android.resource://com.example.bucketlist_challenge_app/drawable/" + R.drawable.bohberger_dunen)
            .toString(),
        "Im Osten Hamburgs wartet die Boberger Düne als letzte Wanderdüne Hamburgs auf euren Besuch! Hier kann man wunderbar auf dem Weg an die Dove Elbe einen Abstecher an die Düne machen, im Boberger See baden und Segelflugzeugen beim Start und der Landung zuschauen. Da ist für jeden was dabei!",
        "26.08.2022",
        "Boberger Furt 50, 21033 Hamburg",
        0.0,
        0.0
    )

}