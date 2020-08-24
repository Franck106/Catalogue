package fr.eql.teama.catalogue.init;

import fr.eql.teama.catalogue.dao.CategoryRepository;
import fr.eql.teama.catalogue.dao.PrestationRepository;
import fr.eql.teama.catalogue.dao.ProposalRepository;
import fr.eql.teama.catalogue.dao.UserRepository;
import fr.eql.teama.catalogue.entities.Category;
import fr.eql.teama.catalogue.entities.Prestation;
import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Date;


@Profile("initData")
@Component
@Transactional
public class InitDataSet {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PrestationRepository prestationRepository;

	@Autowired
	private ProposalRepository proposalRepository;

	@PostConstruct()
	public void initData() {
		// Insert categories
		Category sante = insertCategory(1, "Santé, bien-être", null);
		insertCategory(2, "Massage", sante);
		insertCategory(3, "Manucure", sante);
		insertCategory(4, "Soins esthétiques", sante);
		insertCategory(5, "Coiffure", sante);

		Category aide = insertCategory(10, "Aide à la personne", null);
		insertCategory(11, "Aide scolaire", aide);
		insertCategory(12, "Garde d'enfants", aide);
		insertCategory(13, "Assistance aux personnes âgées", aide);
		insertCategory(14, "Assistance informatique", aide);
		insertCategory(15, "Aide au déménagement", aide);

		Category arts = insertCategory(20, "Arts et création", null);
		insertCategory(21, "Photographie et vidéo", arts);
		insertCategory(22, "Musique et son", arts);
		insertCategory(23, "Illustration et infographie", arts);
		insertCategory(24, "Arts plastiques", arts);
		insertCategory(25, "Arts numériques et multimédia", arts);

		Category maison = insertCategory(30, "Maison et jardin", null);
		insertCategory(31, "Jardinage", maison);
		insertCategory(32, "Repassage", maison);
		insertCategory(33, "Ménage", maison);
		insertCategory(34, "Lavage automobile", maison);
		insertCategory(35, "Bricolage, petit travaux", maison);
		insertCategory(36, "Plomberie", maison);
		insertCategory(37, "Electricité", maison);
		insertCategory(38, "Sols et terrassement", maison);

		Category animaux = insertCategory(40, "Animaux", null);
		insertCategory(41, "Garde d'animaux", animaux);

		Category info = insertCategory(50, "Informatique", null);
		insertCategory(51, "Réseaux sociaux", info);
		insertCategory(52, "Installation d'un ordinateur", info);
		insertCategory(53, "Programmation", info);
		insertCategory(54, "Dépannage informatique", info);

		// Insert clients
		insertUser("Vivien", "Dujardin", "vivien.dujardin@mail.com", "63 Rue Voltaire", "94110", "Arcueil", "0603010001", 1, "91567528914673");
		insertUser("Matthieu", "Ricart", "matthieu.ricart@mail.com", "76 Avenue Raspail", "94250", "Gentilly", "0603010002", 1, "");
		insertUser("Carmel", "Slocumb", "carmel.slocumb@mail.com", "26 Rue d'Estienne d'Orves", "92120", "Montrouge", "0603010003", 1, "");
		insertUser("Lola", "Vercammen", "lola.vercammen@mail.com", "10 Rue Edmond Rousse", "75014", "Paris", "0603010004", 0, "");
		insertUser("Inès", "Schneider", "inès.schneider@mail.com", "30 Rue d'Alésia", "75014", "Paris", "0603010005", 1, "");
		insertUser("Pénélope", "Descamps", "pénélope.descamps@mail.com", "75 Boulevard Arago", "75014", "Paris", "0603010006", 1, "");
		insertUser("Martine", "Boucher", "martine.boucher@mail.com", "57 Rue de Lyon", "75012", "Paris", "0603010007", 0, "16846875468158");
		insertUser("Glen", "Carpentier", "glen.carpentier@mail.com", "29 Rue Merlin", "75011", "Paris", "0603010008", 0, "");
		insertUser("Jean", "Vaillant", "jean.vaillant@mail.com", "22 Rue de la Solidarité", "94400", "Vitry-sur-Seine", "0602149836", 0, "");
		insertUser("Christelle", "Muller", "christelle.muller@mail.com", "99 Rue Jules Lagaisse", "94400", "Vitry-sur-Seine", "0602149837", 1, "");
		insertUser("Kristel", "Bjork", "kristel.bjork@mail.com", "3 Rue Pierre Semard", "94270", "Le Kremlin-Bicêtre", "0602149838", 0, "");
		insertUser("Celia", "Schank", "celia.schank@mail.com", "45 Rue de la Liberté", "92220", "Bagneux", "0602149839", 0, "");
		insertUser("Laurence", "Bailly", "laurence.bailly@mail.com", "140 Rue Boucicaut", "92260", "Fontenay-aux-Roses", "0602149840", 0, "");
		insertUser("Isaac", "Fournier", "isaac.fournier@mail.com", "21 Rue Jean Lavaud", "92260", "Fontenay-aux-Roses", "0602149841", 1, "");
		insertUser("Valérie", "Vidal", "valérie.vidal@mail.com", "1 Rue Tolstoï", "92130", "Issy-les-Moulineaux", "0602149842", 0, "16879458246521");
		insertUser("Geneviève", "Blanc", "geneviève.blanc@mail.com", "69 Rue des Tennerolles", "92210", "Saint-Cloud", "0602149843", 1, "");
		insertUser("Anaïs", "Jacques", "anaïs.jacques@mail.com", "10 Allée Maréchal Foch", "92210", "Saint-Cloud", "0602149844", 1, "");
		insertUser("Lucas", "Renard", "lucas.renard@mail.com", "15 Allées de l'Europe", "92110", "Clichy", "0602149845", 0, "");
		insertUser("Alvina", "Delavega", "alvina.delavega@mail.com", "8 Rue du Jardin Modèle", "92600", "Asnières-sur-Seine", "0602149846", 1, "");
		insertUser("Éléonore", "Payet", "éléonore.payet@mail.com", "22 Rue Dupré", "92600", "Asnières-sur-Seine", "0602149847", 1, "67897834564128");
		insertUser("Corinne", "Marques", "corinne.marques@mail.com", "13 Rue de la Courneuve", "93300", "Aubervilliers", "0602149848", 1, "");
		insertUser("Merlin", "Satchell", "merlin.satchell@mail.com", "48 Rue Francisco Ferrer", "93170", "Bagnolet", "0602149849", 1, "");
		insertUser("Eric", "Chatenais", "eric.chatenais@mail.com", "1 Allée Jacques Daguerre", "94300", "Vincennes", "0602149850", 1, "");
		insertUser("Beatrice", "Malette", "beatrice.malette@mail.com", "7 Avenue Gambetta", "94700", "Maisons-Alfort", "0602149851", 1, "");
		insertUser("Ralph", "Montjoie", "ralph.montjoie@mail.com", "29 Rue de Champagne", "94700", "Maisons-Alfort", "0602149852", 1, "");
		insertUser("Kristopher", "Pilkington", "kristopher.pilkington@mail.com", "3 Rue du Vieux Chemin", "94000", "Créteil", "0602149853", 1, "");
		insertUser("Danielle", "Langlois", "danielle.langlois@mail.com", "Rue de l'Asile Popincourt", "75011", "Paris", "0602149854", 0, "98762864721597");
		insertUser("Jill", "Sol", "jill.sol@mail.com", "2 Rue Eugène Spuller", "75003", "Paris", "0602149855", 1, "");
		insertUser("Elana", "Fiscus", "elana.fiscus@mail.com", "2 rue de la Mare Huguet", "93110", "Rosny-sous-bois", "0602149856", 1, "");
		insertUser("Inès", "Sanschagrin", "inès.sanschagrin@mail.com", "3 rue de l'Escaut", "75019", "Paris", "0602149857", 1, "16845782165795");
		insertUser("Rémy", "Desruisseaux", "rémy.desruisseaux@mail.com", "6 rue Blanche", "75009", "Paris", "0603010031", 1, "");
		insertUser("Armand", "Rodrigue", "armand.rodrigue@mail.com", "7 rue Blanche", "75009", "Paris", "0603010032", 1, "");
		insertUser("Roslyn", "Gaillard", "roslyn.gaillard@mail.com", "10 rue Paul Escudier", "75009", "Paris", "0603010033", 1, "");
		insertUser("Clarice", "Boivin", "clarice.boivin@mail.com", "15 rue  Darcet", "75017", "Paris", "0603010034", 0, "96357885621157");
		insertUser("Gabrielle", "Daigneault", "gabrielle.daigneault@mail.com", "29 Avenue Marceau", "94340", "Joinville-le-Pont", "0603010035", 0, "");
		insertUser("Romain", "Dubé", "romain.dubé@mail.com", "4 Allée des Boutons d'Or", "94000", "Créteil", "0603010036", 0, "");
		insertUser("Lothair", "Huot", "lothair.huot@mail.com", "19 Rue Rodier", "94700", "Maisons-Alfort", "0603010037", 1, "");
		insertUser("Manon", "Chalut", "manon.chalut@mail.com", "10 rue Nollet", "75017", "Paris", "0603010038", 0, "");
		insertUser("Beaufort", "Saurel", "beaufort.saurel@mail.com", "15 Rue des Fusillés", "94400", "Vitry-sur-Seine", "0603010039", 0, "");
		insertUser("Claire", "Poissonnier", "claire.poissonnier@mail.com", "6 rue la Fayette", "75009", "Paris", "0603010040", 1, "");
		insertUser("Donat", "DeLaRonde", "donat.delaronde@mail.com", "22 rue des Pyramides", "75001", "Paris", "0603010041", 0, "");
		insertUser("Roslyn", "Grivois", "roslyn.grivois@mail.com", "6 rue du 29 Juillet", "75001", "Paris", "0603010042", 1, "");
		insertUser("Marshall", "Marchesseault", "marshall.marchesseault@mail.com", "11 Rue Olympe de Gouges", "94400", "Vitry-sur-Seine", "0603010043", 1, "99658824646322");
		insertUser("Charles", "Godin", "charles.godin@mail.com", "29 rue Pierre Nicole", "75005", "Paris", "0603010044", 1, "");
		insertUser("Constance", "Migneault", "constance.migneault@mail.com", "9 Avenue René Coty", "75014", "Paris", "0603010045", 0, "");
		insertUser("Viollette", "Camus", "viollette.camus@mail.com", "35 rue Relos ", "94800", "Villejuif", "0603010046", 0, "");
		insertUser("Felicien", "Séguin", "felicien.séguin@mail.com", "12 rue du Dr Esquirol", "94200", "Ivry-sur-seine", "0603010047", 1, "");
		insertUser("Searlait,", "Bonnet", "searlait,.bonnet@mail.com", "16 rue de Verdun ", "94220", "Charenton-le-Pont", "0603010048", 0, "");
		insertUser("Logistilla", "Pomerleau", "logistilla.pomerleau@mail.com", "7 Passage Carnot", "94270", "Le Kremlin-Bicêtre", "0603010049", 1, "");
		insertUser("Karlotta", "Corbin", "karlotta.corbin@mail.com", "66 Rue Ambroise Croizat", "94800", "Villejuif", "0603010050", 0, "");
		insertUser("Seymour", "Doucet", "seymour.doucet@mail.com", "25 Villa des Bruyères", "94800", "Villejuif", "0603010051", 1, "");
		insertUser("Louise", "Galarneau", "louise.galarneau@mail.com", "10 Rue Ledru Rollin", "94200", "Ivry-sur-Seine", "0603010052", 0, "");
		insertUser("Louis", "Franchet", "louis.franchet@mail.com", "1 Passage Montgallet", "75012", "Paris", "0603010053", 0, "");
		insertUser("Roslyn", "Chassé", "roslyn.chassé@mail.com", "46 Rue de Lagny", "75020", "Paris", "0603010054", 0, "");
		insertUser("Prunella", "Majory", "prunella.majory@mail.com", "17 Rue Henri Poincaré", "75020", "Paris", "0603010055", 1, "");
		insertUser("Melville", "Aubé", "melville.aubé@mail.com", "16 Rue Custine", "75018", "Paris", "0603010056", 1, "");
		insertUser("Capucine", "Marcheterre", "capucine.marcheterre@mail.com", "30 Rue des Graviers", "93400", "Saint-Ouen", "0604152322", 1, "67897834564128");
		insertUser("Marthe", "Marois", "marthe.marois@mail.com", "178 Avenue du Président Wilson", "93210", "Saint-Denis", "0604152323", 0, "");
		insertUser("Emmanuel", "Coudert", "emmanuel.coudert@mail.com", "13 rue des Princes", "92100", "Boulogne Billancourt", "0604152324", 0, "");
		insertUser("Donatien", "Bousquet", "donatien.bousquet@mail.com", "3 Boulevard d'Auteuil", "75016", "Paris", "0604152325", 1, "");
		insertUser("Dexter", "Truchon", "dexter.truchon@mail.com", "21 rue des Bartoux", "92150", "Suresnes", "0604152326", 1, "");
		insertUser("Vignette", "Pirouet", "vignette.pirouet@mail.com", "22 rue des Bartoux", "92150", "Suresnes", "0604152327", 1, "");
		insertUser("Falerina", "Cotuand", "falerina.cotuand@mail.com", "13 rue de la Liberté", "92150", "Suresnes", "0604152328", 0, "");
		insertUser("Alexis", "Archambault", "alexis.archambault@mail.com", "68 rue Voltaire", "92150", "Suresnes", "0604152329", 1, "98762864721597");
		insertUser("Jacquelynn", "Snowden", "jacquelynn.snowden@mail.com", "4 Avenue Thérèse", "92270", "Bois-Colombes", "0604152330", 0, "");
		insertUser("Ivana", "Hults", "ivana.hults@mail.com", "4 rue Gilbert Bonnemaison", "93800", "Epinay-sur-seine", "0604152331", 1, "");
		insertUser("Oleta", "Funderburke", "oleta.funderburke@mail.com", "10 rue de la Chevrette", "93800", "Epinay-sur-seine", "0604152332", 1, "16845782165795");
		insertUser("Suzette", "Ailleboust", "suzette.ailleboust@mail.com", "3 avenue Léon Blum", "93800", "Epinay-sur-seine", "0604152333", 1, "");
		insertUser("Honoré", "Vaillancour", "honoré.vaillancour@mail.com", "Allée des Glycines", "92000", "Nanterre", "0604152334", 0, "");
		insertUser("Eliot", "Pitre", "eliot.pitre@mail.com", "1 Rue Raymond Poincaré", "92420", "Vaucresson", "0604152335", 0, "");
		insertUser("Adèle", "Coulombe", "adèle.coulombe@mail.com", "14 Avenue Chauchard", "78000", "Versailles", "0603010071", 1, "96357885621157");
		insertUser("Auriville", "Brisette", "auriville.brisette@mail.com", "1 Allée des Érables", "78114", "Magny-les-Hameaux", "0603010072", 0, "");
		insertUser("Esperanza", "Saindon", "esperanza.saindon@mail.com", "Chemin Noir", "91680", "Bruyères-le-Châtel", "0603010073", 0, "");
		insertUser("Talbot", "Lagrange", "talbot.lagrange@mail.com", "La Croix Boissée", "91630", "Cheptainville", "0603010074", 0, "");
		insertUser("Théophile", "Marseau", "théophile.marseau@mail.com", "18 Route du Cure", "92410", "Ville-d'Avray", "0603010075", 1, "");
		insertUser("Dreux", "Brasseur", "dreux.brasseur@mail.com", "15 Rue Fernand Enguehard", "92220", "Bagneux", "0603010076", 0, "");
		insertUser("Philippine", "Demers", "philippine.demers@mail.com", "155 bis Avenue Pierre Brossolette", "92120", "Montrouge", "0603010077", 0, "");
		insertUser("Eloise", "Desilets", "eloise.desilets@mail.com", "2 rue Florian", "93500", "Pantin", "0603010078", 0, "");
		insertUser("Aubrey", "Plouffe", "aubrey.plouffe@mail.com", "41 rue Hoche", "93500", "Pantin", "0603010079", 0, "");
		insertUser("Manon", "Généreux", "manon.généreux@mail.com", "7 rue Béranger", "93310", "Le-Pré-Saint-Gervais", "0603010080", 1, "");
		insertUser("Ansel", "Rouze", "ansel.rouze@mail.com", "11 rue Franklin", "93310", "Le-Pré-Saint-Gervais", "0603010081", 1, "");
		insertUser("Marshall", "Martineau", "marshall.martineau@mail.com", "1 Square Alphonse Daudet", "92350", "Le Plessis-Robinson", "0603010082", 0, "");
		insertUser("Legget", "Saurel", "legget.saurel@mail.com", "129 Rue Jean Macé", "92320", "Châtillon", "0603010083", 0, "");
		insertUser("Loring", "Berger", "loring.berger@mail.com", "82 Rue Pierre Brossolette", "92320", "Châtillon", "0603010084", 1, "");
		insertUser("Morgane", "Laboissonniere", "morgane.laboissonniere@mail.com", "6 Passage Dorliat", "92140", "Clamart", "0603010085", 0, "65897833472835");
		insertUser("Hugues", "Chevrette", "hugues.chevrette@mail.com", "74 Rue Pierre Brossolette", "92140", "Clamart", "0605008969", 1, "");
		insertUser("Matthieu", "Carrière", "matthieu.carrière@mail.com", "18 Rue Marius Breton", "92130", "Issy-les-Moulineaux", "0605008970", 1, "");
		insertUser("Gifford", "Bordeleau", "gifford.bordeleau@mail.com", "19 rue du Donjon", "94300", "Vincennes", "0605008971", 0, "");
		insertUser("Alice", "Lauzier", "alice.lauzier@mail.com", "5 Allée Jacques Daguerre", "94300", "Vincennes", "0605008972", 0, "");
		insertUser("Fayme", "Soucy", "fayme.soucy@mail.com", "3 rue de Lisbonne", "93110", "Rosny-sous-bois", "0605008973", 1, "");
		insertUser("Hedvige", "Lereau", "hedvige.lereau@mail.com", "7 rue Philibert Hoffmann", "93110", "Rosny-sous-bois", "0605008974", 0, "");
		insertUser("Gerard", "Mailhot", "gerard.mailhot@mail.com", "48 Avenue Despréaux", "75016", "Paris", "0605008975", 0, "98762864721597");
		insertUser("Christian", "Simard", "christian.simard@mail.com", "24 Rue Moreau Vauthier", "92100", "Boulogne-Billancourt", "0605008976", 0, "");
		insertUser("Gaspar", "Collin", "gaspar.collin@mail.com", "21 Rue Tahère", "92210", "Saint-Cloud", "0605008977", 0, "");
		insertUser("Yseult", "Racine", "yseult.racine@mail.com", "114 Rue Xavier de Maistre", "92500", "Rueil-Malmaison", "0605008978", 1, "16845782165795");
		insertUser("Gemma", "Delaunay", "gemma.delaunay@mail.com", "76 Avenue Meissonier", "93250", "Villemomble", "0605008979", 0, "");
		insertUser("Rule", "Chastain", "rule.chastain@mail.com", "26 rue Pascal", "93250", "Villemomble", "0605008980", 1, "");
		insertUser("Alexandrin", "Sanschagrin", "alexandrin.sanschagrin@mail.com", "Chemin des Ouches", "92500", "Rueil-Malmaison", "0605008981", 0, "");
		insertUser("Colette", "Petit", "colette.petit@mail.com", "10 Rue Paul Doumer", "78110", "Le Vésinet", "0605008982", 1, "22351572115723");
		insertUser("Coralie", "Chalut", "coralie.chalut@mail.com", "41 Place de la Madeleine", "91120", "Palaiseau", "0605008983", 1, "");
		insertUser("Hilaire", "Cormier", "hilaire.cormier@mail.com", "36 Square de la Couronne", "91120", "Palaiseau", "0605008984", 0, "");
		insertUser("Leala", "Migneault", "leala.migneault@mail.com", "40 rue Sébastopol", "17100", "Saintes", "0605008985", 0, "");
		insertUser("Rive", "Bolduc", "rive.bolduc@mail.com", "94 rue de la Hulotais", "59430", "Saint-pol-sur-mer", "0605008986", 1, "");
		insertUser("Timothée", "Gilbert", "timothée.gilbert@mail.com", "76 Chemin Des Bateliers", "49000", "Angers", "0605008987", 0, "");
		insertUser("Delit", "Austin", "delit.austin@mail.com", "38 rue Sadi Carnot", "32000", "Auch", "0605008988", 0, "");
		insertUser("Felicien", "Gougeon", "felicien.gougeon@mail.com", "5 Rue de Verdun", "93370", "Montfermeil", "0605008989", 0, "");
		insertUser("Brier", "Renaud", "brier.renaud@mail.com", "43 rue Adolphe Wurtz", "43000", "Le Puy-en-velay", "0605008990", 0, "66597135448625");
		insertUser("Agnès", "Lespérance", "agnès.lespérance@mail.com", "34 cours Franklin Roosevelt", "13010", "Marseille", "0605008991", 1, "");
		insertUser("Antoinette", "Patenaude", "antoinette.patenaude@mail.com", "94 rue du Clair Bocage", "33260", "La Teste-de-buch", "0605008992", 1, "");
		insertUser("Flordelis", "Trudeau", "flordelis.trudeau@mail.com", "22 Rue du Limas", "64100", "Bayonne", "0605008993", 1, "");
		insertUser("Liane", "Benjamin", "liane.benjamin@mail.com", "29 avenue Jules Ferry", "64100", "Bayonne", "0605008994", 0, "");
		insertUser("Agnès", "Artois", "agnès.artois@mail.com", "2 Rue Roussy", "93130", "Noisy-le-sec", "0605008995", 1, "");
		insertUser("Avice", "Morin", "avice.morin@mail.com", "59 rue Lenotre", "35700", "Rennes", "0605008996", 1, "");
		insertUser("Ray", "Grimard", "ray.grimard@mail.com", "60 rue Lenotre", "35700", "Rennes", "0605008997", 0, "");
		insertUser("Burnell", "Mireault", "burnell.mireault@mail.com", "88 rue Sadi Carnot", "89000", "Auxerre", "0605008998", 0, "");
		insertUser("Serge", "Lamour", "serge.lamour@mail.com", "89 rue Sadi Carnot", "89000", "Auxerre", "0605008999", 1, "");
		insertUser("Amorette", "Bourassa", "amorette.bourassa@mail.com", "90 rue Sadi Carnot", "89000", "Auxerre", "0605009000", 1, "");
		insertUser("Langley", "Baril", "langley.baril@mail.com", "60 rue de Lille", "91200", "Athis-mons", "0605009001", 1, "");
		insertUser("Lowell", "Busque", "lowell.busque@mail.com", "61 rue de Lille", "91200", "Athis-mons", "0605009002", 1, "96995882127465");
		insertUser("Flordelis", "Rivard", "flordelis.rivard@mail.com", "62 rue de Lille", "91200", "Athis-mons", "0605009003", 0, "");
		insertUser("Alain", "Dostie", "alain.dostie@mail.com", "82 cours Jean Jaures", "33200", "Bordeaux", "0605009004", 1, "");
		insertUser("Nadine", "Jolicoeur", "nadine.jolicoeur@mail.com", "83 cours Jean Jaures", "33200", "Bordeaux", "0605009005", 0, "");
		insertUser("Christiane", "Bureau", "christiane.bureau@mail.com", "84 cours Jean Jaures", "33200", "Bordeaux", "0605009006", 1, "");
		insertUser("Mallory", "Lajoie", "mallory.lajoie@mail.com", "1 rue Beauvau", "13004", "Marseille", "0605009007", 0, "11125567913548");
		insertUser("Ormazd", "Bordeleau", "ormazd.bordeleau@mail.com", "2 rue Beauvau", "13004", "Marseille", "0605009008", 1, "");
		insertUser("Hamilton", "Vallée", "hamilton.vallée@mail.com", "3 rue Beauvau", "13004", "Marseille", "0605009009", 1, "");
		insertUser("Anastasie", "Pellerin", "anastasie.pellerin@mail.com", "11 Place de la Gare", "77380", "Combs-la-ville", "0605009010", 1, "");
		insertUser("Laurence", "Brochu", "laurence.brochu@mail.com", "12 Place de la Gare", "77380", "Combs-la-ville", "0605009011", 1, "");
		insertUser("Clémence", "Laux", "clémence.laux@mail.com", "13 Place de la Gare", "77380", "Combs-la-ville", "0605009012", 0, "");
		insertUser("Darcy", "Beauchamp", "darcy.beauchamp@mail.com", "62 Avenue des Tuileries", "78280", "Guyancourt", "0605009013", 1, "");
		insertUser("Telford", "Guernon", "telford.guernon@mail.com", "63 Avenue des Tuileries", "78280", "Guyancourt", "0605009014", 0, "");
		insertUser("Daisi", "Labrecque", "daisi.labrecque@mail.com", "64 Avenue des Tuileries", "78280", "Guyancourt", "0605009015", 1, "");
		insertUser("Marion", "Bois", "marion.bois@mail.com", "39 rue Gontier-Patin", "80100", "Abbeville", "0605009016", 0, "");
		insertUser("Talon", "Desforges", "talon.desforges@mail.com", "40 rue Gontier-Patin", "80100", "Abbeville", "0605009017", 1, "");
		insertUser("Inès", "Vaillancour", "inès.vaillancour@mail.com", "41 rue Gontier-Patin", "80100", "Abbeville", "0605009018", 0, "");
		insertUser("Favor", "Veronneau", "favor.veronneau@mail.com", "54 rue des Dunes", "35400", "Saint-malo", "0605009019", 0, "");
		insertUser("Christian", "Bérard", "christian.bérard@mail.com", "55 rue des Dunes", "35400", "Saint-malo", "0605009020", 0, "");
		insertUser("Solaine", "Arnoux", "solaine.arnoux@mail.com", "56 rue des Dunes", "35400", "Saint-malo", "0605009021", 0, "");
		insertUser("Aurore", "Tanguay", "aurore.tanguay@mail.com", "63 boulevard Bryas", "59170", "Croix", "0605009022", 1, "");
		insertUser("Suzette", "Ailleboust", "suzette.ailleboust@mail.com", "64 boulevard Bryas", "59170", "Croix", "0605009023", 0, "");
		insertUser("Satordi", "Desrosiers", "satordi.desrosiers@mail.com", "65 boulevard Bryas", "59170", "Croix", "0605009024", 1, "");
		insertUser("Auriville", "Loiselle", "auriville.loiselle@mail.com", "26 avenue Voltaire", "92240", "Malakoff", "0603010142", 1, "");
		insertUser("Harriette", "Turgeon", "harriette.turgeon@mail.com", "27 avenue Voltaire", "92240", "Malakoff", "0603010143", 1, "");
		insertUser("Villette", "Fresne", "villette.fresne@mail.com", "28 avenue Voltaire", "92240", "Malakoff", "0603010144", 1, "95665487721511");
		insertUser("Gilles", "Miron", "gilles.miron@mail.com", "68 rue Sadi Carnot", "15000", "Aurillac", "0603010145", 0, "");
		insertUser("Archaimbau", "Beaulé", "archaimbau.beaulé@mail.com", "69 rue Sadi Carnot", "15000", "Aurillac", "0603010146", 0, "");
		insertUser("Jolie", "Garceau", "jolie.garceau@mail.com", "70 rue Sadi Carnot", "15000", "Aurillac", "0603010147", 1, "");
		insertUser("Amabella", "Tanguay", "amabella.tanguay@mail.com", "98 rue du Paillle en queue", "78130", "Les Mureaux", "0603010148", 1, "");
		insertUser("Victor", "Labrosse", "victor.labrosse@mail.com", "99 rue du Paillle en queue", "78130", "Les Mureaux", "0603010149", 1, "");
		insertUser("Toussaint", "Jolicoeur", "toussaint.jolicoeur@mail.com", "100 rue du Paillle en queue", "78130", "Les Mureaux", "0603010150", 1, "");
		insertUser("Rosemarie", "Poisson", "rosemarie.poisson@mail.com", "92 rue de la Mare aux Carats", "34080", "Montpellier", "0603010151", 0, "");
		insertUser("Rosamonde", "Boulanger", "rosamonde.boulanger@mail.com", "93 rue de la Mare aux Carats", "34080", "Montpellier", "0603010152", 0, "");
		insertUser("Fleurette", "Bourdette", "fleurette.bourdette@mail.com", "94 rue de la Mare aux Carats", "34080", "Montpellier", "0603010153", 1, "");
		insertUser("Laurette", "Therrien", "laurette.therrien@mail.com", "66 rue Porte d'Orange", "33150", "Cenon", "0603010154", 1, "");
		insertUser("Amelie", "Gousset", "amelie.gousset@mail.com", "67 rue Porte d'Orange", "33150", "Cenon", "0603010155", 1, "");
		insertUser("Danielle", "Béland", "danielle.béland@mail.com", "68 rue Porte d'Orange", "33150", "Cenon", "0603010156", 1, "");
		insertUser("Jolie", "Chastain", "jolie.chastain@mail.com", "69 rue Porte d'Orange", "33150", "Cenon", "0603010157", 1, "");
		insertUser("Millard", "Desaulniers", "millard.desaulniers@mail.com", "5 rue de la République", "69002", "Lyon", "0603010158", 0, "");
		insertUser("Thérèse", "Pitre", "thérèse.pitre@mail.com", "6 rue de la République", "69002", "Lyon", "0603010159", 0, "");
		insertUser("Orlene", "Bonami", "orlene.bonami@mail.com", "7 rue de la République", "69002", "Lyon", "0603010160", 0, "");
		insertUser("Josephe", "Gingras", "josephe.gingras@mail.com", "8 rue de la République", "69002", "Lyon", "0603010161", 1, "");
		insertUser("Delmare", "Labrosse", "delmare.labrosse@mail.com", "28 Rue Marie De Médicis", "69002", "Lyon", "0603010162", 1, "");
		insertUser("Yvon", "Chaussée", "yvon.chaussée@mail.com", "29 Rue Marie De Médicis", "69002", "Lyon", "0603010163", 1, "");
		insertUser("Julie", "Maheu", "julie.maheu@mail.com", "30 Rue Marie De Médicis", "69002", "Lyon", "0603010164", 0, "");
		insertUser("Royce", "Desnoyers", "royce.desnoyers@mail.com", "20 rue Bonneterie", "12100", "Millau", "0603010165", 1, "");
		insertUser("Flora", "Soucy", "flora.soucy@mail.com", "21 rue Bonneterie", "12100", "Millau", "0603010166", 0, "");
		insertUser("Maryse", "Givry", "maryse.givry@mail.com", "22 rue Bonneterie", "12100", "Millau", "0603010167", 1, "");
		insertUser("Paien", "Fortier", "paien.fortier@mail.com", "65 rue Michel Ange", "76610", "Le Havre", "0603010168", 0, "");
		insertUser("Royce", "Dabigné", "royce.dabigné@mail.com", "66 rue Michel Ange", "76610", "Le Havre", "0603010169", 1, "");
		insertUser("Bartlett", "Lanoie", "bartlett.lanoie@mail.com", "67 rue Michel Ange", "76610", "Le Havre", "0603010170", 1, "");
		insertUser("Yseult", "Berthiaume", "yseult.berthiaume@mail.com", "68 rue Michel Ange", "76610", "Le Havre", "0603010171", 1, "");
		insertUser("Sébastien", "Houle", "sébastien.houle@mail.com", "3 Place de la Gare", "16100", "Cognac", "0603010172", 1, "");
		insertUser("Perrin", "Laforest", "perrin.laforest@mail.com", "4 Place de la Gare", "16100", "Cognac", "0603010173", 0, "");
		insertUser("Odelette", "Berger", "odelette.berger@mail.com", "5 Place de la Gare", "16100", "Cognac", "0603010174", 0, "");
		insertUser("Amedee", "Boisclair", "amedee.boisclair@mail.com", "55 rue de Raymond Poincaré", "92200", "Neuilly-sur-seine", "0603010175", 0, "");
		insertUser("Auriville", "Guédry", "auriville.guédry@mail.com", "56 rue de Raymond Poincaré", "92200", "Neuilly-sur-seine", "0699085252", 0, "");
		insertUser("Bruno", "Berthiaume", "bruno.berthiaume@mail.com", "57 rue de Raymond Poincaré", "92200", "Neuilly-sur-seine", "0699085253", 1, "");
		insertUser("Robinette", "Richard", "robinette.richard@mail.com", "58 rue de Raymond Poincaré", "92200", "Neuilly-sur-seine", "0699085254", 0, "");
		insertUser("Nicholas", "Brisebois", "nicholas.brisebois@mail.com", "22 Boulevard de Normandie", "92260", "Fontenay-aux-roses", "0699085255", 0, "");
		insertUser("Eulalie", "Chevrette", "eulalie.chevrette@mail.com", "66 rue Descartes", "67200", "Strasbourg", "0699085256", 1, "");
		insertUser("Clovis", "Lemieux", "clovis.lemieux@mail.com", "66 rue Descartes", "67200", "Strasbourg", "0699085257", 1, "");
		insertUser("Donatien", "Desjardins", "donatien.desjardins@mail.com", "34 rue La Boétie", "75017", "Paris", "0699085258", 0, "");
		insertUser("Édith", "Bertrand", "édith.bertrand@mail.com", "99 Boulevard de Normandie", "57600", "Forbach", "0699085259", 0, "");
		insertUser("Emmeline", "Perillard", "emmeline.perillard@mail.com", "95 rue Gontier-Patin", "13090", "Aix-en-provence", "0699085260", 0, "");
		insertUser("Etoile", "Forest", "etoile.forest@mail.com", "95 rue Gontier-Patin", "13090", "Aix-en-provence", "0699085261", 0, "");
		insertUser("Liane", "Quinn", "liane.quinn@mail.com", "91 Rue Roussy", "93130", "Noisy-le-sec", "0699085262", 1, "");
		insertUser("Henri", "David", "henri.david@mail.com", "55 rue des Dunes", "38400", "Saint-martin-d'hÈres", "0699085263", 1, "");
		insertUser("Gallia", "Vaillancourt", "gallia.vaillancourt@mail.com", "62 rue Petite Fusterie", "1000", "Bourg-en-bresse", "0699085264", 1, "");
		insertUser("Jacqueline", "Mathieu", "jacqueline.mathieu@mail.com", "35 rue Jean-Monnet", "95190", "Goussainville", "0699085265", 1, "");
		insertUser("Marshall", "Pomerleau", "marshall.pomerleau@mail.com", "35 rue Jean-Monnet", "95190", "Goussainville", "0699085266", 0, "");
		insertUser("Eugène", "Pellerin", "eugène.pellerin@mail.com", "91 Rue Roussy", "93130", "Noisy-le-sec", "0699085267", 1, "");
		insertUser("Marguerite", "Jodoin", "marguerite.jodoin@mail.com", "62 rue Petite Fusterie", "1000", "Bourg-en-bresse", "0699085268", 0, "");
		insertUser("Nicolette", "Leroux", "nicolette.leroux@mail.com", "91 Rue Roussy", "93130", "Noisy-le-sec", "0603010193", 0, "");
		insertUser("Russell", "Guimond", "russell.guimond@mail.com", "35 rue Jean-Monnet", "95190", "Goussainville", "0603010194", 0, "");
		insertUser("Bernard", "Jacques", "bernard.jacques@mail.com", "68 boulevard Aristide Briand", "6110", "Le Cannet", "0603010195", 0, "");
		insertUser("Varden", "Boisvert", "varden.boisvert@mail.com", "13 rue de l'Aigle", "17000", "La Rochelle", "0603010196", 0, "");
		insertUser("Delphine", "Poissonnier", "delphine.poissonnier@mail.com", "68 boulevard Aristide Briand", "6110", "Le Cannet", "0603010197", 0, "");
		insertUser("Garland", "Brousse", "garland.brousse@mail.com", "95 rue Gontier-Patin", "13090", "Aix-en-provence", "0603010198", 0, "");
		insertUser("Joy", "Bonsaint", "joy.bonsaint@mail.com", "62 rue Petite Fusterie", "1000", "Bourg-en-bresse", "0603010199", 0, "");
		insertUser("Tearlach", "Sarrazin", "tearlach.sarrazin@mail.com", "13 rue de l'Aigle", "17000", "La Rochelle", "0603010194", 1, "");

		// Insert proposals
		insertProposal("Bricolage - Petits travaux", "Bricoleur habitué à monter des poignées de cuisine sur petite cuisine aménagée, je propose mes services.", "bricolage.png", 50, 35, 49);
		insertProposal("Bricolage - Petits travaux", "Je suis une personne compétente pour remplacer le carrelage, n'hésitez pas, je suis disponible immédiatement.", "bricolage.png", 40, 35, 35);
		insertProposal("Bricolage - Petits travaux", "Sérieux, disponible, je suis à votre service pour tout petit boulot du weekend.", "bricolage.png", 20, 35, 5);
		insertProposal("Bricolage - Petits travaux", "Bon bricoleur, capable de monter un moteur de store électrique Somfy.", "bricolage.png", 50, 35, 100);
		insertProposal("Bricolage - Petits travaux", "Organisé et débrouillard , j'ai travaillé comme peintre, électricien et plaquiste.", "bricolage.png", 20, 35, 62);
		insertProposal("Bricolage - Petits travaux", "Humblement à votre disposition pour tous types de travaux.", "bricolage.png", 35, 35, 33);
		insertProposal("Jardinage", "Je suis qualifié, diplômé, et j'ai de l'expérience dans le domaine des espaces verts.", "jardinage.png", 40, 31, 2);
		insertProposal("Jardinage", "Je recherche du travail en espaces verts, en extérieur ou en intérieur. ", "jardinage.png", 20, 31, 94);
		insertProposal("Jardinage", " Dépanneur systèmes d'arrosage, je suis disponible et à l'écoute.", "jardinage.png", 15, 31, 12);
		insertProposal("Jardinage", "Je propose mes services pour l'entretien de votre jardin.", "jardinage.png", 30, 31, 20);
		insertProposal("Jardinage", "Aide jardinier disponible immédiatement et à votre disposition.", "jardinage.png", 15, 31, 19);
		insertProposal("Garde d'enfants", "J’ai une formation dans le baby-sitting j’aime m’occuper des enfants etsuis une grande amoureuse des animaux ! Étant véhiculé j’ai la possibilité de me déplacer ", "garde_enfant.png", 12, 12, 29);
		insertProposal("Garde d'enfants", "En tant qu’étudiante de 19 ans je vous propose mes services dans divers domaines tels que le ménage, la garde de vos enfants et de vos animaux.", "garde_enfant.png", 12, 12, 39);
		insertProposal("Garde d'enfants", "J' ai mon bep carrières sanitaires et sociales et mon cap petite enfance. Je garde des enfants depuis plus de 10 ans. Je suis disponible , le week end, pendant les vacances et à partir de juillet tout le temps.", "garde_enfant.png", 12, 12, 27);
		insertProposal("Garde d'enfants", " Je fais du babysitting, du soutien scolaire spécialement en mathématiques et en sciences, j'ai été serveuse pendant 5 ans à côté de mes études. ", "garde_enfant.png", 12, 12, 98);
		insertProposal("Garde d'enfants", "Habituée aux baby sitting pour enfants de tous âges je vous propose mes services en toute sécurité je peux me rendre disponible facilement.", "garde_enfant.png", 12, 12, 9);
		insertProposal("Soin & Bien être", "Coiffeuse à domicile ou en déplacement, disponible et efficace.", "bien_etre.png", 20, 1, 90);
		insertProposal("Soin & Bien être", "Esthéticienne certifiée et spécialisée dans les publics fragiles (profession para médicale reconnue comme soin de support en oncologie), les soins que je propose sont adaptés à la personne et à sa situation.", "bien_etre.png", 35, 1, 90);
		insertProposal("Soin & Bien être", "Coucou les filles , je vous propose le rehaussement des cils qui sublimera votre regard. Avec teinture si vous le souhaitez. Le rehaussement dure entre 2 et 3 mois. ", "bien_etre.png", 30, 1, 48);
		insertProposal("Soin & Bien être", "Je vous propose des soins esthétiques de qualité avec des produits professionnels (épilation toutes zones, soins de mains et des pieds, maquillage, conseils en image), je suis aussi prothésiste ongulaire.", "bien_etre.png", 60, 1, 56);
		insertProposal("Soin & Bien être", "Masseuse expérimentée et délicate, je propose des massages de 30min à 2h à petits prix.", "bien_etre.png", 50, 1, 93);
		insertProposal("Soin & Bien être", "Esthéticienne à domicile passionnée et diplômée depuis plus de 10ans. Je vous propose un moment de detente privilégié sans bouger de chez vous", "bien_etre.png", 30, 1, 61);
		insertProposal("Soin & Bien être", "Je suis Esthéticienne depuis maintenant plus de 6 ans. Je propose mes services à mon domicile.", "bien_etre.png", 25, 1, 20);
		insertProposal("Garde d'enfants", "J'ai mon bep carrières sanitaires et sociales et mon cap petite enfance. Je garde des enfants depuis plus de 10 ans. Je suis disponible , le week end, pendant les vacances et à partir de juillet tout le temps.", "garde_enfant.png", 20, 12, 78);
		insertProposal("Aide au déménagement", "Jeune père de famille aimant la vie, je prends plaisir à aider les personnes sollicitent mes services. Je possède un camion 12m3 adapté à toute sorte de missions.", "demenagement.png", 10, 15, 24);
		insertProposal("Aide au déménagement", "Je souhaite proposer mes services. Mes amis me décrivent comme une personne serviable, bricoleur et patient. ", "demenagement.png", 16, 15, 58);
		insertProposal("Aide au déménagement", "Disponible sur Paris et alentours pour travaux variés, quelques heures en semaine et le week-end pour compléter mes revenus. : déménagements, manutention, etc..)", "demenagement.png", 30, 15, 63);
		insertProposal("Aide au déménagement", " je suis disponible pour votre déménagement transport à votre disposition 3 camion 10. 15 et 22m3 entièrement équipé pour les déménagements couverture de protection, diable, sangle, plateau roulant,chariot capacité 200kg.", "demenagement.png", 18, 15, 45);
		insertProposal("Aide au déménagement", "Grand professionnel, actif et très motivé, je suis disponible pour vous aider dans vos déménagements principalement puisque je dispose de mes propres camions (2 fois 22m3).", "demenagement.png", 20, 15, 25);
		insertProposal("Assistance aux personnes âgées", "Infirmière à mi-temps s'occupe des personnes âgées à domicile : soins basiques, courses, toilette,...", "assistance.png", 45, 13, 7);
		insertProposal("Assistance aux personnes âgées", "Etudiante en pharmacie est disponible pour apporter aide et compagnie aux personnes qui en ont besoin", "assistance.png", 40, 13, 100);
		insertProposal("Assistance informatique", "Aide pour utiliser un ordinateur : bureautique, emails, naviguer sur internet,...", "informatique.png", 10, 14, 98);
		insertProposal("Assistance informatique", "Je créé des sites internet sur mesure pour votre boutique en ligne, votre portefolio, votre blog...", "informatique.png", 30, 14, 38);
		insertProposal("Photographie et vidéo", "Photographie de mariage, évenements d'entreprise, anniversaires...", "photo.png", 80, 21, 22);
		insertProposal("Photographie et vidéo", "Photographe passioné (tout type), je propose mes services en région parisienne", "photo.png", 40, 21, 6);
		insertProposal("Photographie et vidéo", "Photographe et vidéaste confirmé pour tous projets sérieux", "photo.png", 40, 21, 82);
		insertProposal("Musique et son", "Propose cours de piano à domicile, tout âge et tous niveaux", "musique.png", 35, 22, 23);
		insertProposal("Musique et son", "Cours de piano et de solfège pour débutants", "musique.png", 42, 22, 43);
		insertProposal("Musique et son", "Prestation DJ, karaoke pour tous types d'événements. Location de matériel possible", "musique.png", 100, 22, 43);
		insertProposal("Musique et son", "Professeur en conservatoire de violon propose cours à domicile tous niveaux", "musique.png", 50, 22, 40);
		insertProposal("Illustration et infographie", "Etudiant en infographie propose ses services pour création de logos, de charte graphique, réalisation de site webs...", "infographie.png", 30, 23, 88);
		insertProposal("Arts plastiques", "Cours de menuiserie en groupe. 3 niveaux (débutant, intermédiaire, avancé).", "arts_plastiques.png", 28, 24, 52);
		insertProposal("Arts numériques et multimédia", "J'anime chaque week end des projections de films cultes suivis de discussions généralement animées autour d'un cocktail. Rejoignez-nous!", "multimedia.png", 5, 25, 42);
		insertProposal("Jardinage", "Jardinier passionné pour l'entretien du jardin de particuliers", "jardinage.png", 15, 31, 83);
		insertProposal("Jardinage", "Je propose ma main verte et mon entrain pour faire de votre jardin un coin de paradis", "jardinage.png", 12, 31, 96);
		insertProposal("Jardinage", "TONDRE LA PELOUSE, TAILLAGE HAIE ETC PLUS DINFOS MP", "jardinage.png", 1, 31, 58);
		insertProposal("Arts et création", "Je réalise des pièces au crochet sur mesure et propose également des cours individuels", "arts.png", 10, 20, 9);
		insertProposal("Arts et création", "Cours de poterie en groupe tous niveaux", "arts.png", 35, 20, 21);
		insertProposal("Plomberie", "Professionel consciencieux pour plomberie", "plomberie.png", 50, 36, 87);
		insertProposal("Lavage automobile", "Passionné moto et auto, j'entretiens votre véhicule avec soin. dispo WE", "automobile.png", 15, 34, 48);
		insertProposal("Lavage automobile", "Lavage et entretien (contrôle technique) rapide efficace", "automobile.png", 12, 34, 89);
		insertProposal("Ménage", "Je fais des ménages, repassage je suis véhiculée.", "menage.png", 10, 33, 59);
		insertProposal("Ménage", "Je vous propose mes services pour faire le ménage dans votre domicile, je suis très sérieuse, consciencieuse, très attentionné, efficace, dynamique.", "menage.png", 11, 33, 64);
		insertProposal("Ménage", "J'ai déjà travaillé en tant qu'aide ménagère pendant 5 ans dans une hôtel, repassage, aspirateur, hygiène général. ", "menage.png", 11, 33, 98);
		insertProposal("Ménage", "Après avoir obtenu mon diplôme ADVF, j'ai occupé un poste en qualité d'agent à domicile pendant 3 ans suite à cela, j'ai décidé de créer ma propre société de service à la personne.", "menage.png", 13, 33, 59);
		insertProposal("Ménage", "De nature maniaque et pointilleuse, je réalise vos travaux de ménage, repassage et nettoyage. Je connais également pleins de petites astuces écologique et économiques.", "menage.png", 10, 33, 37);
		insertProposal("Plomberie", "Je suis disponible pour tous travaux de la maison peinture, plomberie, montage de meubles, faïence, parquet, rénovation.", "plomberie.png", 10, 36, 9);
		insertProposal("Plomberie", "J'aide les personnes démunies face à un petit problème ,et évite les abus ou des dépenses (très) importantes lors d'interventions comme plomberie ou serrurerie .", "plomberie.png", 12, 36, 12);
		insertProposal("Plomberie", "Expérience plomberie \"domestique\". Connaissance forte des produits chimiques adaptés / outillage classique pour changements joints courants.", "plomberie.png", 13, 36, 60);
		insertProposal("Plomberie", "Je suis plombier chauffagiste de métier, j’ai les compétences nécessaires pour tous types d’installation, dépannage et rénovation.", "plomberie.png", 11, 36, 29);
		insertProposal("Eléctricité", "Je suis quelqu’un de polyvalent, électrotechnicien de formation, habile de mes mains, je monte et démonte, fixe tout type de mobilier, je décolle, et colle du papier peint.", "electricite.png", 10, 37, 97);
		insertProposal("Eléctricité", "Je suis disponible cette semaine mais aussi tous les soirs et les weekends , pour le bricolage (électricité ..)", "electricite.png", 15, 37, 9);
		insertProposal("Eléctricité", "Électricien professionnel diplômé (bep,bac électrotechnique) et expérimenté (+10 ans). Installation,dépannage,mise aux normes,conseil.", "electricite.png", 12, 37, 80);
		insertProposal("Eléctricité", "Etant électricien de formation ,avec une forte compétence dans ce domaine ,je me ferai un grand plaisir de pouvoir vous aider .", "electricite.png", 12, 37, 46);

		// Insert services
		insertPrestation(1, 23, 76, 1, 0, 4, 0);
		insertPrestation(2, 7, 47, 1, 0, 5, 4);
		insertPrestation(3, 37, 51, 1, 1, 2, 5);
		insertPrestation(4, 20, 41, 1, 1, 5, 0);
		insertPrestation(5, 25, 42, 1, 1, 2, 4);
		insertPrestation(6, 38, 61, 1, 1, 4, 5);
		insertPrestation(7, 8, 40, 1, 0, 2, 2);
		insertPrestation(8, 46, 68, 0, 1, 5, 3);
		insertPrestation(9, 34, 83, 0, 1, 4, 2);
		insertPrestation(10, 3, 16, 0, 0, 3, 5);
		insertPrestation(11, 35, 96, 0, 1, 1, 3);
		insertPrestation(12, 19, 65, 0, 1, 2, 5);
		insertPrestation(13, 4, 67, 1, 1, 1, 1);
		insertPrestation(14, 19, 67, 1, 0, 2, 1);
		insertPrestation(15, 20, 98, 0, 0, 3, 1);
		insertPrestation(16, 35, 85, 1, 0, 2, 4);
		insertPrestation(17, 34, 49, 1, 1, 4, 1);
		insertPrestation(18, 31, 41, 0, 1, 1, 4);
		insertPrestation(19, 30, 80, 1, 1, 1, 3);
		insertPrestation(20, 20, 60, 0, 1, 0, 3);
		insertPrestation(21, 39, 52, 0, 0, 0, 2);
		insertPrestation(22, 10, 35, 1, 0, 3, 1);
		insertPrestation(23, 5, 97, 1, 1, 3, 1);
		insertPrestation(24, 25, 98, 0, 1, 0, 1);
		insertPrestation(25, 8, 91, 1, 0, 1, 0);
		insertPrestation(26, 47, 11, 1, 0, 4, 1);
		insertPrestation(27, 40, 83, 1, 1, 0, 3);
		insertPrestation(28, 32, 7, 1, 0, 3, 0);
	}

	private void insertPrestation(int id, int proposalId, int customerId, int finished, int cancelled, int ratingClient, int ratingProvider) {
		Prestation prestation = new Prestation();
		prestation.setId(id);
		prestation.setProposal(proposalRepository.findById(proposalId).orElse(null));
		prestation.setCustomer(userRepository.findById(customerId).orElse(null));
		prestation.setCancelled(cancelled == 1);
		prestation.setDelivered(finished == 1);
		prestation.setCustomerRating(ratingClient);
		prestation.setProviderRating(ratingProvider);

		// TODO
		prestation.setStartDate(new Date());
		prestation.setEndDate(new Date());

		prestationRepository.save(prestation);
	}

	private void insertProposal(String name, String description, String picture, int price, int categoryId, int userId) {
		Proposal proposal = new Proposal();
		proposal.setName(name);
		proposal.setDescription(description);
		proposal.setImage(picture);
		proposal.setPrice((double)price);
		proposal.setCategory(categoryRepository.findById(categoryId).orElse(null));
		proposal.setUser(userRepository.findById(userId).orElse(null));

		proposalRepository.save(proposal);
	}

	private void insertUser(String firstName, String lastName, String email, String address, String postalCode, String city, String phone, int premium, String registrationNumber) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setAddress(address);
		user.setPostCode(postalCode);
		user.setCity(city);
		user.setPhoneNumber(phone);
		user.setPremium(premium == 1);
		user.setRegistrationNumber(registrationNumber);

		userRepository.save(user);
	}

	private Category insertCategory(int id, String name, Category parentCategory) {
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setCategory(parentCategory);

		return categoryRepository.save(category);
	}
}
