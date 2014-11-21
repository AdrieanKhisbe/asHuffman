# Intro

Implémentation de l'[Algorithme de compression d'Huffman, version Dynamique/Adaptative](http://fr.wikipedia.org/wiki/Codage_de_Huffman)

# Usage

## Programme

Invoquer la classe main `core.asHuffman` avec les commandes suivantes
			 - **c[ompression]** *fichier_à_compresser fichier_compressé*
			 -  **d[ecompression]** *fichier_compressé fichier_decompressé*
			 -  **t[est]** *fichier_à_compresser fichier_decompressé*
			 -  **chaine** chaine_à_compresser fichier_compressé*
			 - **chainetest** *chaine_à_compresser fichier_compress*
		    -  **[b]enchmark** *fichier_stats fichiers* 
<!-- TODO: build jar, with main class-->
## API
*Do you realy seriously want to use this in an industrial project?*

# Auteurs
Adrien Becchis et Stéphane Ferreira, dans le cadre du Cours Algorithmique Avancée du Master STL, automne 2013

Le rapport associé au projet se trouve dans le dossier du meme nom. Les données de benchmark se trouvent dans l'archive 
`data.tgz`, et les stats on été générée à l'aide du programme avec la commande `benchmark`. (exemple fichier `statsSample.org`)

**Update** Avec le recul et l'expérience, ce code mérite de nombreux refactors de diverses natures. (archi, dp, api files...)
Un build serait ajoutée, la doc bien plus développée, certains commit renommés, des streams dédiés crées...
Mais encore faudrait il qu'il y ai un vrai besoin pour cela :)

<!-- TODO License... -->
<!-- Add Pdf rapport... (liens fichier de bench?) -->