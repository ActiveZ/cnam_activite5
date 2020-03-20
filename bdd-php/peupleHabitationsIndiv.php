<?php
// fonction privée pour remplir l'annuaire dans la bdd

require_once 'bdd' . DIRECTORY_SEPARATOR . 'bdd.php'; //connexion à la bdd

$nbUsers = 1000;
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
    $surface = rand(50,500); //surface entre 50 et 500 m²
    $nbPiece = rand(1,10); // entre 1 et 10 pièces
    $piscine = rand(1,10)==10 ? 1 : 0; // 1 chance sur 10 d'avoir une piscine
    //$tel = getTel();

    $req = $pdo->prepare('INSERT INTO habitationsIndiv (nomProprietaire, adresseLocal, surfaceHabitation, nbPiece, piscine) 
                            VALUES (:nom, :adresse, :surface, :nbPiece, :piscine)');
    $req->execute(['nom' => $nom,
                    'adresse' => $adresse,
                    'surface' => $surface,
                    'nbPiece' => $nbPiece,
                    'piscine' => $piscine]
                    );
}
echo 'Remplissage table habitationsIndiv avec ' . $nbUsers . ' valeurs: terminé';
?>