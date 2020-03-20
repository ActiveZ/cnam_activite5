<?php
// fonction privée pour remplir l'annuaire dans la bdd

require_once 'bdd' . DIRECTORY_SEPARATOR . 'bdd.php'; //connexion à la bdd

$nbUsers = 100;
// liste des villes habitables par les users
 $tabVilles = [["75000","Paris"],
                 ["13000","Marseille"],
                 ["69000","Lyon"],
                 ["31000","Toulouse"],
                 ["06000","Nice"], 
                 ["44000","Nantes"], 
                 ["34000","Montpellier"], 
                 ["67000","Strasbourg"], 
                 ["33000","Bordeaux"], 
                 ["59000","Lille"]];


function getTel() { //retourne un num tel sou la forme 06xxxxxxxx
    $num="06";
    for ($i=0; $i<8; $i++) {
        $num.=rand(0,9);
    }
    return $num;
}

//---------------------------------------------------//

for ($i=0; $i<$nbUsers; $i++) {
    $nom = "nom" . $i;
    $rnd=rand(0,9);
    $adresse = $tabVilles[$rnd][0] . " " . $tabVilles[$rnd][1];
    $surface = rand(50,1000); //surface entre 50 et 1000 m²
    $nbEmploye = rand(0,100); // entre 0 et 100 employés
    //$tel = getTel();

    $req = $pdo->prepare('INSERT INTO habitationsPro (nomProprietaire, adresseLocal, surfaceLocal, nbEmploye) 
                            VALUES (:nom, :adresse, :surface, :nbEmploye)');
    $req->execute(['nom' => $nom,
                    'adresse' => $adresse,
                    'surface' => $surface,
                    'nbEmploye' => $nbEmploye]
                    );
}
echo 'Remplissage table habitationsPro avec ' . $nbUsers . ' valeurs: terminé';
?>