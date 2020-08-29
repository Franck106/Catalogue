package fr.eql.teama.catalogue.init;

import fr.eql.teama.catalogue.dao.*;
import fr.eql.teama.catalogue.entities.*;
import fr.eql.teama.catalogue.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;


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

	@Autowired
	private CredentialsRepository credentialsRepository;

	@Autowired
	private CredentialsService credentialsService;

	@PostConstruct()
	public void initData() throws NoSuchAlgorithmException {
		// Insert categories
		Category soins = insertCategory(1, "Soin & Bien-être", "bien_etre.png");
		insertCategory(2, "Massage", soins);
		insertCategory(3, "Manucure", soins);
		insertCategory(4, "Soins esthétiques", soins);
		insertCategory(5, "Coiffure", soins);

		Category aide = insertCategory(10, "Aide à la personne", "garde_enfant.png");
		insertCategory(11, "Aide scolaire", aide);
		insertCategory(12, "Garde d'enfants", aide);
		insertCategory(13, "Assistance aux personnes âgées", aide);
		insertCategory(14, "Assistance informatique", aide);
		insertCategory(15, "Aide au déménagement", aide);
		insertCategory(16, "Garde d'animaux", aide);

		Category arts = insertCategory(20, "Arts et création", "arts.png");
		insertCategory(21, "Photographie et vidéo", arts);
		insertCategory(22, "Musique et son", arts);
		insertCategory(23, "Illustration et infographie", arts);
		insertCategory(24, "Arts plastiques", arts);
		insertCategory(25, "Arts numériques et multimédia", arts);
		insertCategory(26, "Loisirs créatifs", arts);

		Category maison = insertCategory(30, "Maison et jardin", "jardinage.png");
		insertCategory(31, "Jardinage", maison);
		insertCategory(32, "Repassage", maison);
		insertCategory(33, "Ménage", maison);
		insertCategory(34, "Lavage automobile", maison);
		insertCategory(35, "Bricolage, petit travaux", maison);
		insertCategory(36, "Plomberie", maison);
		insertCategory(37, "Electricité", maison);
		insertCategory(38, "Sols et terrassement", maison);

		Category info = insertCategory(50, "Informatique", "informatique.png");
		insertCategory(51, "Réseaux sociaux", info);
		insertCategory(52, "Installation d'un ordinateur", info);
		insertCategory(53, "Programmation", info);
		insertCategory(54, "Dépannage informatique", info);

		// Insert clients
		insertUser("Vivien", "Dujardin", 4, "https://randomuser.me/api/portraits/men/75.jpg", "vivien.dujardin@mail.com", "63 Rue Voltaire", "94110", "Arcueil", "0603010001", 0, "91567528914673", "{\"lat\":48.810950, \"lng\":2.334130}", "m");
		insertUser("Matthieu", "Ricart", 4, "https://randomuser.me/api/portraits/men/23.jpg", "matthieu.ricart@mail.com", "76 Avenue Raspail", "94250", "Gentilly", "0603010002", 0, "", "{\"lat\":48.810780, \"lng\":2.344760}", "m");
		insertUser("Carmel", "Slocumb", 4, "https://randomuser.me/api/portraits/women/86.jpg", "carmel.slocumb@mail.com", "26 Rue d'Estienne d'Orves", "92120", "Montrouge", "0603010003", 1, "", "{\"lat\":48.814980, \"lng\":2.323150}", "f");
		insertUser("Lola", "Vercammen", 4, "https://randomuser.me/api/portraits/women/45.jpg", "lola.vercammen@mail.com", "10 Rue Edmond Rousse", "75014", "Paris", "0603010004", 0, "", "{\"lat\":48.822880, \"lng\":2.324010}", "f");
		insertUser("Inès", "Schneider", 4, "https://randomuser.me/api/portraits/women/98.jpg", "inès.schneider@mail.com", "30 Rue d'Alésia", "75014", "Paris", "0603010005", 1, "", "{\"lat\":48.827920, \"lng\":2.330390}", "f");
		insertUser("Pénélope", "Descamps", 4, "https://randomuser.me/api/portraits/women/90.jpg", "pénélope.descamps@mail.com", "75 Boulevard Arago", "75014", "Paris", "0603010006", 0, "", "{\"lat\":48.834974, \"lng\":2.341075}", "f");
		insertUser("Martine", "Boucher", 4, "https://randomuser.me/api/portraits/women/37.jpg", "martine.boucher@mail.com", "57 Rue de Lyon", "75012", "Paris", "0603010007", 0, "16846875468158", "{\"lat\":48.850511, \"lng\":2.370244}", "f");
		insertUser("Glen", "Carpentier", 4, "https://randomuser.me/api/portraits/men/12.jpg", "glen.carpentier@mail.com", "29 Rue Merlin", "75011", "Paris", "0603010008", 0, "", "{\"lat\":48.861206, \"lng\":2.384188}", "m");
		insertUser("Jeanne", "Vaillant", 4, "https://randomuser.me/api/portraits/women/95.jpg", "j.vaillant@mail.com", "22 Rue de la Solidarité", "94400", "Vitry-sur-Seine", "0602149836", 1, "", "{\"lat\":48.802032, \"lng\":2.385581}", "m");
		insertUser("Christelle", "Muller", 4, "https://randomuser.me/api/portraits/women/89.jpg", "christelle.muller@mail.com", "99 Rue Jules Lagaisse", "94400", "Vitry-sur-Seine", "0602149837", 0, "", "{\"lat\":48.798006, \"lng\":2.378678}", "f");
		insertUser("Kristel", "Bjork", 4, "https://randomuser.me/api/portraits/women/19.jpg", "kristel.bjork@mail.com", "3 Rue Pierre Semard", "94270", "Le Kremlin-Bicêtre", "0602149838", 0, "", "{\"lat\":48.803028, \"lng\":2.346396}", "f");
		insertUser("Celia", "Schank", 4, "https://randomuser.me/api/portraits/women/68.jpg", "celia.schank@mail.com", "45 Rue de la Liberté", "92220", "Bagneux", "0602149839", 1, "", "{\"lat\":48.794551, \"lng\":2.317581}", "f");
		insertUser("Laurence", "Bailly", 4, "https://randomuser.me/api/portraits/women/34.jpg", "laurence.bailly@mail.com", "140 Rue Boucicaut", "92260", "Fontenay-aux-Roses", "0602149840", 1, "", "{\"lat\":48.795670, \"lng\":2.285736}", "f");
		insertUser("Mathide", "Fournier", 4, "https://randomuser.me/api/portraits/women/37.jpg", "mathide.fournier@mail.com", "21 Rue Jean Lavaud", "92260", "Fontenay-aux-Roses", "0602149841", 0, "", "{\"lat\":48.791450, \"lng\":2.282327}", "f");
		insertUser("Valérie", "Vidal", 4, "https://randomuser.me/api/portraits/women/77.jpg", "valérie.vidal@mail.com", "1 Rue Tolstoï", "92130", "Issy-les-Moulineaux", "0602149842", 0, "16879458246521", "{\"lat\":48.818282, \"lng\":2.264665}", "f");
		insertUser("Geneviève", "Blanc", 4, "https://randomuser.me/api/portraits/women/58.jpg", "geneviève.blanc@mail.com", "69 Rue des Tennerolles", "92210", "Saint-Cloud", "0602149843", 0, "", "{\"lat\":48.846050, \"lng\":2.207742}", "f");
		insertUser("Anaïs", "Jacques", 4, "https://randomuser.me/api/portraits/women/10.jpg", "anaïs.jacques@mail.com", "10 Allée Maréchal Foch", "92210", "Saint-Cloud", "0602149844", 1, "", "{\"lat\":48.848805, \"lng\":2.206872}", "f");
		insertUser("Lucas", "Renard", 4, "https://randomuser.me/api/portraits/men/92.jpg", "lucas.renard@mail.com", "15 Allées de l'Europe", "92110", "Clichy", "0602149845", 1, "", "{\"lat\":48.910969, \"lng\":2.308138}", "m");
		insertUser("Alvina", "Delavega", 4, "https://randomuser.me/api/portraits/women/29.jpg", "alvina.delavega@mail.com", "8 Rue du Jardin Modèle", "92600", "Asnières-sur-Seine", "0602149846", 1, "", "{\"lat\":48.914147, \"lng\":2.306312}", "f");
		insertUser("Éléonore", "Payet", 4, "https://randomuser.me/api/portraits/women/39.jpg", "éléonore.payet@mail.com", "22 Rue Dupré", "92600", "Asnières-sur-Seine", "0602149847", 1, "67897834564128", "{\"lat\":48.912987, \"lng\":2.278536}", "f");
		insertUser("Corinne", "Marques", 4, "https://randomuser.me/api/portraits/women/74.jpg", "corinne.marques@mail.com", "13 Rue de la Courneuve", "93300", "Aubervilliers", "0602149848", 0, "", "{\"lat\":48.915780, \"lng\":2.384082}", "f");
		insertUser("Marie", "Satchell", 4, "https://randomuser.me/api/portraits/women/51.jpg", "marie.satchell@mail.com", "48 Rue Francisco Ferrer", "93170", "Bagnolet", "0602149849", 0, "", "{\"lat\":48.872485, \"lng\":2.421098}", "m");
		insertUser("Eric", "Chatenais", 4, "https://randomuser.me/api/portraits/men/84.jpg", "eric.chatenais@mail.com", "1 Allée Jacques Daguerre", "94300", "Vincennes", "0602149850", 1, "", "{\"lat\":48.843320, \"lng\":2.430348}", "m");
		insertUser("Beatrice", "Malette", 4, "https://randomuser.me/api/portraits/women/41.jpg", "beatrice.malette@mail.com", "7 Avenue Gambetta", "94700", "Maisons-Alfort", "0602149851", 1, "", "{\"lat\":48.810361, \"lng\":2.435153}", "f");
		insertUser("Ralph", "Montjoie", 4, "https://randomuser.me/api/portraits/men/50.jpg", "ralph.montjoie@mail.com", "29 Rue de Champagne", "94700", "Maisons-Alfort", "0602149852", 0, "", "{\"lat\":48.812968, \"lng\":2.435080}", "m");
		insertUser("Kristopher", "Pilkington", 4, "https://randomuser.me/api/portraits/men/79.jpg", "kristopher.pilkington@mail.com", "3 Rue du Vieux Chemin", "94000", "Créteil", "0602149853", 0, "", "{\"lat\":48.803515, \"lng\":2.454358}", "m");
		insertUser("Danielle", "Langlois", 4, "https://randomuser.me/api/portraits/women/1.jpg", "danielle.langlois@mail.com", "Rue de l'Asile Popincourt", "75011", "Paris", "0602149854", 1, "98762864721597", "{\"lat\":48.859881, \"lng\":2.374546}", "f");
		insertUser("Jill", "Sol", 4, "https://randomuser.me/api/portraits/women/60.jpg", "jill.sol@mail.com", "2 Rue Eugène Spuller", "75003", "Paris", "0602149855", 1, "", "{\"lat\":48.863905, \"lng\":2.361611}", "f");
		insertUser("Elana", "Fiscus", 4, "https://randomuser.me/api/portraits/women/14.jpg", "elana.fiscus@mail.com", "2 rue de la Mare Huguet", "93110", "Rosny-sous-bois", "0602149856", 1, "", "{\"lat\":48.866779, \"lng\":2.485992}", "f");
		insertUser("Inès", "Sanschagrin", 4, "https://randomuser.me/api/portraits/women/35.jpg", "inès.sanschagrin@mail.com", "3 rue de l'Escaut", "75019", "Paris", "0602149857", 0, "16845782165795", "{\"lat\":48.892888, \"lng\":2.374004}", "f");
		insertUser("Rémy", "Desruisseaux", 4, "https://randomuser.me/api/portraits/men/87.jpg", "rémy.desruisseaux@mail.com", "6 rue Blanche", "75009", "Paris", "0603010031", 1, "", "{\"lat\":48.877151, \"lng\":2.332329}", "m");
		insertUser("Armand", "Rodrigue", 4, "https://randomuser.me/api/portraits/men/58.jpg", "armand.rodrigue@mail.com", "7 rue Blanche", "75009", "Paris", "0603010032", 0, "", "{\"lat\":48.877657, \"lng\":2.331836}", "m");
		insertUser("Roslyn", "Gaillard", 4, "https://randomuser.me/api/portraits/women/36.jpg", "roslyn.gaillard@mail.com", "10 rue Paul Escudier", "75009", "Paris", "0603010033", 0, "", "{\"lat\":48.880358, \"lng\":2.332818}", "f");
		insertUser("Clarice", "Boivin", 4, "https://randomuser.me/api/portraits/women/31.jpg", "clarice.boivin@mail.com", "15 rue  Darcet", "75017", "Paris", "0603010034", 1, "96357885621157", "{\"lat\":48.884230, \"lng\":2.324590}", "f");
		insertUser("Gabrielle", "Daigneault", 4, "https://randomuser.me/api/portraits/women/94.jpg", "gabrielle.daigneault@mail.com", "29 Avenue Marceau", "94340", "Joinville-le-Pont", "0603010035", 1, "", "{\"lat\":48.825913, \"lng\":2.475377}", "f");
		insertUser("Romain", "Dubé", 4, "https://randomuser.me/api/portraits/men/55.jpg", "romain.dubé@mail.com", "4 Allée des Boutons d'Or", "94000", "Créteil", "0603010036", 0, "", "{\"lat\":48.800896, \"lng\":2.452927}", "m");
		insertUser("Lothair", "Huot", 4, "https://randomuser.me/api/portraits/men/61.jpg", "lothair.huot@mail.com", "19 Rue Rodier", "94700", "Maisons-Alfort", "0603010037", 0, "", "{\"lat\":48.798252, \"lng\":2.430149}", "m");
		insertUser("Manon", "Chalut", 4, "https://randomuser.me/api/portraits/women/21.jpg", "manon.chalut@mail.com", "10 rue Nollet", "75017", "Paris", "0603010038", 1, "", "{\"lat\":48.885215, \"lng\":2.324212}", "f");
		insertUser("Jeanne", "Saurel", 4, "https://randomuser.me/api/portraits/women/4.jpg", "jeanne.saurel@mail.com", "15 Rue des Fusillés", "94400", "Vitry-sur-Seine", "0603010039", 0, "", "{\"lat\":48.787463, \"lng\":2.415310}", "f");
		insertUser("Claire", "Poissonnier", 4, "https://randomuser.me/api/portraits/women/51.jpg", "claire.poissonnier@mail.com", "6 rue la Fayette", "75009", "Paris", "0603010040", 1, "", "{\"lat\":48.873229, \"lng\":2.334187}", "f");
		insertUser("Donat", "DeLaRonde", 4, "https://randomuser.me/api/portraits/men/40.jpg", "donat.delaronde@mail.com", "22 rue des Pyramides", "75001", "Paris", "0603010041", 0, "", "{\"lat\":48.865895, \"lng\":2.333983}", "m");
		insertUser("Roslyn", "Grivois", 4, "https://randomuser.me/api/portraits/women/66.jpg", "roslyn.grivois@mail.com", "6 rue du 29 Juillet", "75001", "Paris", "0603010042", 1, "", "{\"lat\":48.865004, \"lng\":2.330649}", "f");
		insertUser("Marshall", "Marchesseault", 3, "https://randomuser.me/api/portraits/men/55.jpg", "marshall.marchesseault@mail.com", "11 Rue Olympe de Gouges", "94400", "Vitry-sur-Seine", "0603010043", 1, "99658824646322", "{\"lat\":48.779300, \"lng\":2.402358}", "m");
		insertUser("Charles", "Godin", 3, "https://randomuser.me/api/portraits/men/69.jpg", "charles.godin@mail.com", "29 rue Pierre Nicole", "75005", "Paris", "0603010044", 0, "", "{\"lat\":48.840227, \"lng\":2.339221}", "m");
		insertUser("Constance", "Migneault", 3, "https://randomuser.me/api/portraits/women/24.jpg", "constance.migneault@mail.com", "9 Avenue René Coty", "75014", "Paris", "0603010045", 1, "", "{\"lat\":48.831083, \"lng\":2.333894}", "f");
		insertUser("Viollette", "Camus", 3, "https://randomuser.me/api/portraits/women/14.jpg", "viollette.camus@mail.com", "35 rue Relos ", "94800", "Villejuif", "0603010046", 0, "", "{\"lat\":48.801335, \"lng\":2.361918}", "f");
		insertUser("Felicien", "Séguin", 3, "https://randomuser.me/api/portraits/men/87.jpg", "felicien.séguin@mail.com", "12 rue du Dr Esquirol", "94200", "Ivry-sur-seine", "0603010047", 1, "", "{\"lat\":48.814612, \"lng\":2.385371}", "m");
		insertUser("Annie", "Bonnet", 3, "https://randomuser.me/api/portraits/women/81.jpg", "annie.bonnet@mail.com", "16 rue de Verdun ", "94220", "Charenton-le-Pont", "0603010048", 0, "", "{\"lat\":48.824322, \"lng\":2.408063}", "f");
		insertUser("Logistilla", "Pomerleau", 3, "https://randomuser.me/api/portraits/women/32.jpg", "logistilla.pomerleau@mail.com", "7 Passage Carnot", "94270", "Le Kremlin-Bicêtre", "0603010049", 1, "", "{\"lat\":48.808524, \"lng\":2.365842}", "f");
		insertUser("Karlotta", "Corbin", 3, "https://randomuser.me/api/portraits/women/49.jpg", "karlotta.corbin@mail.com", "66 Rue Ambroise Croizat", "94800", "Villejuif", "0603010050", 0, "", "{\"lat\":48.801728, \"lng\":2.360282}", "f");
		insertUser("Seymour", "Doucet", 3, "https://randomuser.me/api/portraits/men/76.jpg", "seymour.doucet@mail.com", "25 Villa des Bruyères", "94800", "Villejuif", "0603010051", 0, "", "{\"lat\":48.788503, \"lng\":2.351948}", "m");
		insertUser("Louise", "Galarneau", 3, "https://randomuser.me/api/portraits/women/58.jpg", "louise.galarneau@mail.com", "10 Rue Ledru Rollin", "94200", "Ivry-sur-Seine", "0603010052", 1, "", "{\"lat\":48.815602, \"lng\":2.382627}", "f");
		insertUser("Louis", "Franchet", 3, "https://randomuser.me/api/portraits/men/69.jpg", "louis.franchet@mail.com", "1 Passage Montgallet", "75012", "Paris", "0603010053", 1, "", "{\"lat\":48.843746, \"lng\":2.387972}", "m");
		insertUser("Roslyn", "Chassé", 3, "img/default.png", "roslyn.chassé@mail.com", "46 Rue de Lagny", "75020", "Paris", "0603010054", 0, "", "{\"lat\":48.848726, \"lng\":2.403819}", "");
		insertUser("Prunella", "Majory", 3, "img/default.png", "prunella.majory@mail.com", "17 Rue Henri Poincaré", "75020", "Paris", "0603010055", 0, "", "{\"lat\":48.870448, \"lng\":2.401232}", "");
		insertUser("Melville", "Aubé", 3, "https://randomuser.me/api/portraits/men/74.jpg", "melville.aubé@mail.com", "16 Rue Custine", "75018", "Paris", "0603010056", 1, "", "{\"lat\":48.888313, \"lng\":2.348191}", "m");
		insertUser("Capucine", "Marcheterre", 3, "https://randomuser.me/api/portraits/women/17.jpg", "capucine.marcheterre@mail.com", "30 Rue des Graviers", "93400", "Saint-Ouen", "0604152322", 1, "67897834564128", "{\"lat\":48.902844, \"lng\":2.350338}", "f");
		insertUser("Marthe", "Marois", 3, "https://randomuser.me/api/portraits/women/79.jpg", "marthe.marois@mail.com", "178 Avenue du Président Wilson", "93210", "Saint-Denis", "0604152323", 0, "", "{\"lat\":48.911954, \"lng\":2.358324}", "f");
		insertUser("Emmanuel", "Coudert", 3, "https://randomuser.me/api/portraits/men/30.jpg", "emmanuel.coudert@mail.com", "13 rue des Princes", "92100", "Boulogne Billancourt", "0604152324", 0, "", "{\"lat\":48.839693, \"lng\":2.249806}", "m");
		insertUser("Donatien", "Bousquet", 3, "https://randomuser.me/api/portraits/men/85.jpg", "donatien.bousquet@mail.com", "3 Boulevard d'Auteuil", "75016", "Paris", "0604152325", 0, "", "{\"lat\":48.845374, \"lng\":2.253608}", "m");
		insertUser("Dexter", "Truchon", 3, "https://randomuser.me/api/portraits/men/95.jpg", "dexter.truchon@mail.com", "21 rue des Bartoux", "92150", "Suresnes", "0604152326", 1, "", "{\"lat\":48.875799, \"lng\":2.220130}", "m");
		insertUser("Vignette", "Pirouet", 3, "https://randomuser.me/api/portraits/women/4.jpg", "vignette.pirouet@mail.com", "22 rue des Bartoux", "92150", "Suresnes", "0604152327", 0, "", "{\"lat\":48.875769, \"lng\":2.220666}", "f");
		insertUser("Falerina", "Cotuand", 3, "https://randomuser.me/api/portraits/women/36.jpg", "falerina.cotuand@mail.com", "13 rue de la Liberté", "92150", "Suresnes", "0604152328", 0, "", "{\"lat\":48.876513, \"lng\":2.222414}", "f");
		insertUser("Alexis", "Archambault", 3, "https://randomuser.me/api/portraits/men/93.jpg", "alexis.archambault@mail.com", "68 rue Voltaire", "92150", "Suresnes", "0604152329", 1, "98762864721597", "{\"lat\":48.878468, \"lng\":2.224528}", "m");
		insertUser("Jacquelynn", "Snowden", 3, "https://randomuser.me/api/portraits/women/3.jpg", "jacquelynn.snowden@mail.com", "4 Avenue Thérèse", "92270", "Bois-Colombes", "0604152330", 0, "", "{\"lat\":48.915920, \"lng\":2.263234}", "f");
		insertUser("Ivana", "Hults", 3, "https://randomuser.me/api/portraits/women/81.jpg", "ivana.hults@mail.com", "4 rue Gilbert Bonnemaison", "93800", "Epinay-sur-seine", "0604152331", 0, "", "{\"lat\":48.955119, \"lng\":2.311284}", "f");
		insertUser("Oleta", "Funderburke", 3, "https://randomuser.me/api/portraits/women/32.jpg", "oleta.funderburke@mail.com", "10 rue de la Chevrette", "93800", "Epinay-sur-seine", "0604152332", 1, "16845782165795", "{\"lat\":48.955467, \"lng\":2.317435}", "f");
		insertUser("Suzette", "Ailleboust", 3, "https://randomuser.me/api/portraits/women/51.jpg", "suzette.ailleboust@mail.com", "3 avenue Léon Blum", "93800", "Epinay-sur-seine", "0604152333", 0, "", "{\"lat\":48.958916, \"lng\":2.313000}", "f");
		insertUser("Honorée", "Vaillancour", 3, "https://randomuser.me/api/portraits/women/99.jpg", "h.vaillancour@mail.com", "Allée des Glycines", "92000", "Nanterre", "0604152334", 0, "", "{\"lat\":48.909791, \"lng\":2.223508}", "m");
		insertUser("Eliot", "Pitre", 3, "https://randomuser.me/api/portraits/men/98.jpg", "eliot.pitre@mail.com", "1 Rue Raymond Poincaré", "92420", "Vaucresson", "0604152335", 1, "", "{\"lat\":48.842295, \"lng\":2.167407}", "m");
		insertUser("Adèle", "Coulombe", 3, "https://randomuser.me/api/portraits/women/57.jpg", "adèle.coulombe@mail.com", "14 Avenue Chauchard", "78000", "Versailles", "0603010071", 1, "96357885621157", "{\"lat\":48.799903, \"lng\":2.157084}", "f");
		insertUser("Susie", "Menton", 3, "https://randomuser.me/api/portraits/women/48.jpg", "susie.menton@mail.com", "1 Allée des Érables", "78114", "Magny-les-Hameaux", "0603010072", 1, "", "{\"lat\":48.715824, \"lng\":2.100713}", "f");
		insertUser("Esperanza", "Saindon", 3, "https://randomuser.me/api/portraits/women/11.jpg", "esperanza.saindon@mail.com", "Chemin Noir", "91680", "Bruyères-le-Châtel", "0603010073", 0, "", "{\"lat\":48.602913, \"lng\":2.201598}", "f");
		insertUser("Talbot", "Lagrange", 3, "https://randomuser.me/api/portraits/women/94.jpg", "talbot.lagrange@mail.com", "La Croix Boissée", "91630", "Cheptainville", "0603010074", 0, "", "{\"lat\":48.546820, \"lng\":2.258861}", "f");
		insertUser("Théophile", "Marseau", 3, "https://randomuser.me/api/portraits/men/2.jpg", "théophile.marseau@mail.com", "18 Route du Cure", "92410", "Ville-d'Avray", "0603010075", 1, "", "{\"lat\":48.825727, \"lng\":2.182630}", "m");
		insertUser("Dreux", "Brasseur", 3, "https://randomuser.me/api/portraits/men/21.jpg", "dreux.brasseur@mail.com", "15 Rue Fernand Enguehard", "92220", "Bagneux", "0603010076", 1, "", "{\"lat\":48.796071, \"lng\":2.309165}", "m");
		insertUser("Philippine", "Demers", 3, "https://randomuser.me/api/portraits/women/84.jpg", "philippine.demers@mail.com", "155 bis Avenue Pierre Brossolette", "92120", "Montrouge", "0603010077", 1, "", "{\"lat\":48.815621, \"lng\":2.305130}", "f");
		insertUser("Eloise", "Desilets", 3, "https://randomuser.me/api/portraits/women/59.jpg", "eloise.desilets@mail.com", "2 rue Florian", "93500", "Pantin", "0603010078", 0, "", "{\"lat\":48.894495, \"lng\":2.401730}", "f");
		insertUser("Aubrey", "Plouffe", 3, "https://randomuser.me/api/portraits/women/57.jpg", "aubrey.plouffe@mail.com", "41 rue Hoche", "93500", "Pantin", "0603010079", 1, "", "{\"lat\":48.893970, \"lng\":2.401718}", "f");
		insertUser("Manon", "Généreux", 3, "https://randomuser.me/api/portraits/women/51.jpg", "manon.généreux@mail.com", "7 rue Béranger", "93310", "Le-Pré-Saint-Gervais", "0603010080", 0, "", "{\"lat\":48.888293, \"lng\":2.400281}", "f");
		insertUser("Ansel", "Rouze", 3, "https://randomuser.me/api/portraits/men/21.jpg", "ansel.rouze@mail.com", "11 rue Franklin", "93310", "Le-Pré-Saint-Gervais", "0603010081", 0, "", "{\"lat\":48.888502, \"lng\":2.402715}", "m");
		insertUser("Marshall", "Martineau", 3, "https://randomuser.me/api/portraits/men/93.jpg", "marshall.martineau@mail.com", "1 Square Alphonse Daudet", "92350", "Le Plessis-Robinson", "0603010082", 1, "", "{\"lat\":48.781612, \"lng\":2.257646}", "m");
		insertUser("Marion", "Palace", 3, "https://randomuser.me/api/portraits/women/44.jpg", "marion.palace@mail.com", "129 Rue Jean Macé", "92320", "Châtillon", "0603010083", 0, "", "{\"lat\":48.804386, \"lng\":2.291102}", "f");
		insertUser("Laurine", "Berger", 3, "https://randomuser.me/api/portraits/women/36.jpg", "laurine.berger@mail.com", "82 Rue Pierre Brossolette", "92320", "Châtillon", "0603010084", 1, "", "{\"lat\":48.801680, \"lng\":2.277385}", "f");
		insertUser("Morgane", "Laboissonniere", 3, "https://randomuser.me/api/portraits/women/43.jpg", "morgane.laboissonniere@mail.com", "6 Passage Dorliat", "92140", "Clamart", "0603010085", 0, "65897833472835", "{\"lat\":48.806641, \"lng\":2.266122}", "f");
		insertUser("Hugues", "Chevrette", 3, "https://randomuser.me/api/portraits/men/41.jpg", "hugues.chevrette@mail.com", "74 Rue Pierre Brossolette", "92140", "Clamart", "0605008969", 1, "", "{\"lat\":48.808831, \"lng\":2.262440}", "m");
		insertUser("Matthieu", "Carrière", 3, "https://randomuser.me/api/portraits/men/18.jpg", "matthieu.carrière@mail.com", "18 Rue Marius Breton", "92130", "Issy-les-Moulineaux", "0605008970", 0, "", "{\"lat\":48.819034, \"lng\":2.271406}", "m");
		insertUser("Gifford", "Bordeleau", 3, "https://randomuser.me/api/portraits/women/68.jpg", "gifford.bordeleau@mail.com", "19 rue du Donjon", "94300", "Vincennes", "0605008971", 1, "", "{\"lat\":48.843307, \"lng\":2.431774}", "f");
		insertUser("Alice", "Lauzier", 3, "https://randomuser.me/api/portraits/women/19.jpg", "alice.lauzier@mail.com", "5 Allée Jacques Daguerre", "94300", "Vincennes", "0605008972", 1, "", "{\"lat\":48.842643, \"lng\":2.430231}", "f");
		insertUser("Fayme", "Soucy", 3, "https://randomuser.me/api/portraits/women/97.jpg", "fayme.soucy@mail.com", "3 rue de Lisbonne", "93110", "Rosny-sous-bois", "0605008973", 0, "", "{\"lat\":48.878470, \"lng\":2.475349}", "f");
		insertUser("Hedvige", "Lereau", 3, "https://randomuser.me/api/portraits/women/44.jpg", "hedvige.lereau@mail.com", "7 rue Philibert Hoffmann", "93110", "Rosny-sous-bois", "0605008974", 1, "", "{\"lat\":48.879911, \"lng\":2.484214}", "f");
		insertUser("Gerard", "Mailhot", 3, "https://randomuser.me/api/portraits/men/96.jpg", "gerard.mailhot@mail.com", "48 Avenue Despréaux", "75016", "Paris", "0605008975", 1, "98762864721597", "{\"lat\":48.844321, \"lng\":2.262487}", "m");
		insertUser("Christian", "Simard", 3, "https://randomuser.me/api/portraits/men/1.jpg", "christian.simard@mail.com", "24 Rue Moreau Vauthier", "92100", "Boulogne-Billancourt", "0605008976", 0, "", "{\"lat\":48.845233, \"lng\":2.243201}", "m");
		insertUser("Gaspar", "Collin", 3, "https://randomuser.me/api/portraits/men/70.jpg", "gaspar.collin@mail.com", "21 Rue Tahère", "92210", "Saint-Cloud", "0605008977", 1, "", "{\"lat\":48.846574, \"lng\":2.211361}", "m");
		insertUser("Yseult", "Racine", 3, "https://randomuser.me/api/portraits/women/53.jpg", "yseult.racine@mail.com", "114 Rue Xavier de Maistre", "92500", "Rueil-Malmaison", "0605008978", 0, "16845782165795", "{\"lat\":48.875406, \"lng\":2.187853}", "f");
		insertUser("Gemma", "Delaunay", 3, "https://randomuser.me/api/portraits/women/58.jpg", "gemma.delaunay@mail.com", "76 Avenue Meissonier", "93250", "Villemomble", "0605008979", 1, "", "{\"lat\":48.887897, \"lng\":2.497872}", "f");
		insertUser("Rule", "Chastain", 3, "https://randomuser.me/api/portraits/men/85.jpg", "rule.chastain@mail.com", "26 rue Pascal", "93250", "Villemomble", "0605008980", 1, "", "{\"lat\":48.887384, \"lng\":2.498984}", "m");
		insertUser("Alexandrine", "Sanschagrin", 3, "https://randomuser.me/api/portraits/women/42.jpg", "alexandrine.sanschagrin@mail.com", "Chemin des Ouches", "92500", "Rueil-Malmaison", "0605008981", 0, "", "{\"lat\":48.860982, \"lng\":2.161087}", "m");
		insertUser("Colette", "Petit", 3, "https://randomuser.me/api/portraits/women/50.jpg", "colette.petit@mail.com", "10 Rue Paul Doumer", "78110", "Le Vésinet", "0605008982", 1, "22351572115723", "{\"lat\":48.885094, \"lng\":2.144602}", "f");
		insertUser("Coralie", "Chalut", 3, "https://randomuser.me/api/portraits/women/21.jpg", "coralie.chalut@mail.com", "41 Place de la Madeleine", "91120", "Palaiseau", "0605008983", 1, "", "{\"lat\":46.18968918, \"lng\":1.096269912}", "f");
		insertUser("Hilaire", "Cormier", 3, "https://randomuser.me/api/portraits/women/55.jpg", "hilaire.cormier@mail.com", "36 Square de la Couronne", "91120", "Palaiseau", "0605008984", 0, "", "{\"lat\":46.76631117, \"lng\":1.654014417}", "f");
		insertUser("Leala", "Migneault", 3, "https://randomuser.me/api/portraits/women/68.jpg", "leala.migneault@mail.com", "40 rue Sébastopol", "17100", "Saintes", "0605008985", 0, "", "{\"lat\":47.69307154, \"lng\":3.16605306}", "f");
		insertUser("Gilles", "Bolduc", 3, "https://randomuser.me/api/portraits/men/32.jpg", "gilles.bolduc@mail.com", "94 rue de la Hulotais", "59430", "Saint-pol-sur-mer", "0605008986", 0, "", "{\"lat\":48.21569015, \"lng\":1.510995994}", "m");
		insertUser("Timothée", "Gilbert", 3, "https://randomuser.me/api/portraits/men/55.jpg", "timothée.gilbert@mail.com", "76 Chemin Des Bateliers", "49000", "Angers", "0605008987", 0, "", "{\"lat\":47.87669405, \"lng\":3.422346016}", "m");
		insertUser("Audrey", "Austin", 3, "https://randomuser.me/api/portraits/women/4.jpg", "audrey.austin@mail.com", "38 rue Sadi Carnot", "32000", "Auch", "0605008988", 0, "", "{\"lat\":47.23402109, \"lng\":2.329713713}", "f");
		insertUser("Felicien", "Gougeon", 3, "https://randomuser.me/api/portraits/men/71.jpg", "felicien.gougeon@mail.com", "5 Rue de Verdun", "93370", "Montfermeil", "0605008989", 1, "", "{\"lat\":46.20942384, \"lng\":2.819988826}", "m");
		insertUser("Baptiste", "Renaud", 3, "https://randomuser.me/api/portraits/men/62.jpg", "baptiste.renaud@mail.com", "43 rue Adolphe Wurtz", "43000", "Le Puy-en-velay", "0605008990", 0, "66597135448625", "{\"lat\":45.6393554, \"lng\":1.246094247}", "m");
		insertUser("Agnès", "Lespérance", 3, "img/default.png", "agnès.lespérance@mail.com", "34 cours Franklin Roosevelt", "13010", "Marseille", "0605008991", 0, "", "{\"lat\":46.00983649, \"lng\":2.61433636}", "");
		insertUser("Antoinette", "Patenaude", 3, "img/default.png", "antoinette.patenaude@mail.com", "94 rue du Clair Bocage", "33260", "La Teste-de-buch", "0605008992", 1, "", "{\"lat\":46.28129434, \"lng\":3.886274999}", "");
		insertUser("Flordelis", "Trudeau", 3, "img/default.png", "flordelis.trudeau@mail.com", "22 Rue du Limas", "64100", "Bayonne", "0605008993", 1, "", "{\"lat\":48.33198385, \"lng\":2.541600715}", "");
		insertUser("Liane", "Benjamin", 4, "img/default.png", "liane.benjamin@mail.com", "29 avenue Jules Ferry", "64100", "Bayonne", "0605008994", 0, "", "{\"lat\":45.42267084, \"lng\":2.076091633}", "");
		insertUser("Agnès", "Artois", 4, "img/default.png", "agnès.artois@mail.com", "2 Rue Roussy", "93130", "Noisy-le-sec", "0605008995", 0, "", "{\"lat\":45.92880127, \"lng\":0.2068451259}", "");
		insertUser("Avice", "Morin", 4, "img/default.png", "avice.morin@mail.com", "59 rue Lenotre", "35700", "Rennes", "0605008996", 0, "", "{\"lat\":46.73645507, \"lng\":1.348449842}", "");
		insertUser("Ray", "Grimard", 4, "img/default.png", "ray.grimard@mail.com", "60 rue Lenotre", "35700", "Rennes", "0605008997", 1, "", "{\"lat\":47.78637977, \"lng\":2.666933276}", "");
		insertUser("Burnell", "Mireault", 4, "img/default.png", "burnell.mireault@mail.com", "88 rue Sadi Carnot", "89000", "Auxerre", "0605008998", 1, "", "{\"lat\":45.97459357, \"lng\":3.140456641}", "");
		insertUser("Serge", "Lamour", 4, "img/default.png", "serge.lamour@mail.com", "89 rue Sadi Carnot", "89000", "Auxerre", "0605008999", 0, "", "{\"lat\":45.16652263, \"lng\":3.251056292}", "");
		insertUser("Amorette", "Bourassa", 4, "img/default.png", "amorette.bourassa@mail.com", "90 rue Sadi Carnot", "89000", "Auxerre", "0605009000", 0, "", "{\"lat\":45.37059752, \"lng\":2.623396326}", "");
		insertUser("Langley", "Baril", 4, "img/default.png", "langley.baril@mail.com", "60 rue de Lille", "91200", "Athis-mons", "0605009001", 1, "", "{\"lat\":48.43181874, \"lng\":2.993406201}", "");
		insertUser("Lowell", "Busque", 4, "img/default.png", "lowell.busque@mail.com", "61 rue de Lille", "91200", "Athis-mons", "0605009002", 0, "96995882127465", "{\"lat\":47.79368848, \"lng\":0.2732390452}", "");
		insertUser("Flordelis", "Rivard", 4, "img/default.png", "flordelis.rivard@mail.com", "62 rue de Lille", "91200", "Athis-mons", "0605009003", 0, "", "{\"lat\":48.34822844, \"lng\":0.1831016686}", "");
		insertUser("Alain", "Dostie", 4, "img/default.png", "alain.dostie@mail.com", "82 cours Jean Jaures", "33200", "Bordeaux", "0605009004", 0, "", "{\"lat\":47.1212414, \"lng\":2.011587111}", "");
		insertUser("Nadine", "Jolicoeur", 4, "img/default.png", "nadine.jolicoeur@mail.com", "83 cours Jean Jaures", "33200", "Bordeaux", "0605009005", 0, "", "{\"lat\":45.05866281, \"lng\":1.673090367}", "");
		insertUser("Christiane", "Bureau", 4, "img/default.png", "christiane.bureau@mail.com", "84 cours Jean Jaures", "33200", "Bordeaux", "0605009006", 1, "", "{\"lat\":46.58745702, \"lng\":2.545111497}", "");
		insertUser("Mallory", "Lajoie", 4, "img/default.png", "mallory.lajoie@mail.com", "1 rue Beauvau", "13004", "Marseille", "0605009007", 1, "11125567913548", "{\"lat\":45.58119498, \"lng\":2.843656095}", "");
		insertUser("Ormazd", "Bordeleau", 4, "img/default.png", "ormazd.bordeleau@mail.com", "2 rue Beauvau", "13004", "Marseille", "0605009008", 1, "", "{\"lat\":48.08885658, \"lng\":2.847936922}", "");
		insertUser("Hamilton", "Vallée", 4, "img/default.png", "hamilton.vallée@mail.com", "3 rue Beauvau", "13004", "Marseille", "0605009009", 0, "", "{\"lat\":48.47069639, \"lng\":3.495069202}", "");
		insertUser("Anastasie", "Pellerin", 4, "img/default.png", "anastasie.pellerin@mail.com", "11 Place de la Gare", "77380", "Combs-la-ville", "0605009010", 0, "", "{\"lat\":48.77484484, \"lng\":2.172838908}", "");
		insertUser("Laurence", "Brochu", 4, "img/default.png", "laurence.brochu@mail.com", "12 Place de la Gare", "77380", "Combs-la-ville", "0605009011", 1, "", "{\"lat\":48.19284916, \"lng\":2.447820201}", "");
		insertUser("Clémence", "Laux", 4, "img/default.png", "clémence.laux@mail.com", "13 Place de la Gare", "77380", "Combs-la-ville", "0605009012", 1, "", "{\"lat\":48.72424468, \"lng\":3.543523863}", "");
		insertUser("Darcy", "Beauchamp", 4, "img/default.png", "darcy.beauchamp@mail.com", "62 Avenue des Tuileries", "78280", "Guyancourt", "0605009013", 0, "", "{\"lat\":45.7946399, \"lng\":0.2577874021}", "");
		insertUser("Telford", "Guernon", 4, "img/default.png", "telford.guernon@mail.com", "63 Avenue des Tuileries", "78280", "Guyancourt", "0605009014", 1, "", "{\"lat\":47.10636329, \"lng\":3.371669043}", "");
		insertUser("Daisi", "Labrecque", 4, "img/default.png", "daisi.labrecque@mail.com", "64 Avenue des Tuileries", "78280", "Guyancourt", "0605009015", 0, "", "{\"lat\":46.61559899, \"lng\":1.207591572}", "");
		insertUser("Marion", "Bois", 4, "img/default.png", "marion.bois@mail.com", "39 rue Gontier-Patin", "80100", "Abbeville", "0605009016", 1, "", "{\"lat\":47.94780555, \"lng\":0.6588048021}", "");
		insertUser("Talon", "Desforges", 4, "img/default.png", "talon.desforges@mail.com", "40 rue Gontier-Patin", "80100", "Abbeville", "0605009017", 0, "", "{\"lat\":48.06920319, \"lng\":2.614300265}", "");
		insertUser("Inès", "Vaillancour", 4, "img/default.png", "inès.vaillancour@mail.com", "41 rue Gontier-Patin", "80100", "Abbeville", "0605009018", 1, "", "{\"lat\":46.4739071, \"lng\":3.184529284}", "");
		insertUser("Favor", "Veronneau", 4, "img/default.png", "favor.veronneau@mail.com", "54 rue des Dunes", "35400", "Saint-malo", "0605009019", 0, "", "{\"lat\":46.93401727, \"lng\":3.497548254}", "");
		insertUser("Christian", "Bérard", 4, "img/default.png", "christian.bérard@mail.com", "55 rue des Dunes", "35400", "Saint-malo", "0605009020", 1, "", "{\"lat\":46.966314, \"lng\":3.148950123}", "");
		insertUser("Solaine", "Arnoux", 4, "img/default.png", "solaine.arnoux@mail.com", "56 rue des Dunes", "35400", "Saint-malo", "0605009021", 0, "", "{\"lat\":46.12930614, \"lng\":3.781048075}", "");
		insertUser("Aurore", "Tanguay", 4, "img/default.png", "aurore.tanguay@mail.com", "63 boulevard Bryas", "59170", "Croix", "0605009022", 1, "", "{\"lat\":45.17589558, \"lng\":2.928655496}", "");
		insertUser("Suzette", "Ailleboust", 4, "img/default.png", "suzette.ailleboust@mail.com", "64 boulevard Bryas", "59170", "Croix", "0605009023", 0, "", "{\"lat\":47.61000453, \"lng\":3.454370555}", "");
		insertUser("Satordi", "Desrosiers", 4, "img/default.png", "satordi.desrosiers@mail.com", "65 boulevard Bryas", "59170", "Croix", "0605009024", 0, "", "{\"lat\":48.55283004, \"lng\":0.9219224903}", "");
		insertUser("Auriville", "Loiselle", 4, "img/default.png", "auriville.loiselle@mail.com", "26 avenue Voltaire", "92240", "Malakoff", "0603010142", 1, "", "{\"lat\":48.80108957, \"lng\":0.5007811922}", "");
		insertUser("Harriette", "Turgeon", 4, "img/default.png", "harriette.turgeon@mail.com", "27 avenue Voltaire", "92240", "Malakoff", "0603010143", 0, "", "{\"lat\":45.9033599, \"lng\":1.900276774}", "");
		insertUser("Villette", "Fresne", 4, "img/default.png", "villette.fresne@mail.com", "28 avenue Voltaire", "92240", "Malakoff", "0603010144", 0, "95665487721511", "{\"lat\":46.90155463, \"lng\":2.900825408}", "");
		insertUser("Gilles", "Miron", 4, "img/default.png", "gilles.miron@mail.com", "68 rue Sadi Carnot", "15000", "Aurillac", "0603010145", 0, "", "{\"lat\":46.5553707, \"lng\":3.849924534}", "");
		insertUser("Archaimbau", "Beaulé", 4, "img/default.png", "archaimbau.beaulé@mail.com", "69 rue Sadi Carnot", "15000", "Aurillac", "0603010146", 0, "", "{\"lat\":46.4233425, \"lng\":1.650260384}", "");
		insertUser("Jolie", "Garceau", 4, "img/default.png", "jolie.garceau@mail.com", "70 rue Sadi Carnot", "15000", "Aurillac", "0603010147", 0, "", "{\"lat\":47.71260335, \"lng\":1.977982699}", "");
		insertUser("Amabella", "Tanguay", 4, "img/default.png", "amabella.tanguay@mail.com", "98 rue du Paillle en queue", "78130", "Les Mureaux", "0603010148", 0, "", "{\"lat\":48.49074952, \"lng\":2.484838992}", "");
		insertUser("Victor", "Labrosse", 4, "img/default.png", "victor.labrosse@mail.com", "99 rue du Paillle en queue", "78130", "Les Mureaux", "0603010149", 1, "", "{\"lat\":45.39996467, \"lng\":0.3748411849}", "");
		insertUser("Toussaint", "Jolicoeur", 4, "img/default.png", "toussaint.jolicoeur@mail.com", "100 rue du Paillle en queue", "78130", "Les Mureaux", "0603010150", 0, "", "{\"lat\":47.71097025, \"lng\":3.883357349}", "");
		insertUser("Rosemarie", "Poisson", 4, "img/default.png", "rosemarie.poisson@mail.com", "92 rue de la Mare aux Carats", "34080", "Montpellier", "0603010151", 1, "", "{\"lat\":47.25005871, \"lng\":0.765396531}", "");
		insertUser("Rosamonde", "Boulanger", 4, "img/default.png", "rosamonde.boulanger@mail.com", "93 rue de la Mare aux Carats", "34080", "Montpellier", "0603010152", 0, "", "{\"lat\":45.83660744, \"lng\":1.924281845}", "");
		insertUser("Fleurette", "Bourdette", 4, "img/default.png", "fleurette.bourdette@mail.com", "94 rue de la Mare aux Carats", "34080", "Montpellier", "0603010153", 1, "", "{\"lat\":46.35371807, \"lng\":1.84830085}", "");
		insertUser("Laurette", "Therrien", 4, "img/default.png", "laurette.therrien@mail.com", "66 rue Porte d'Orange", "33150", "Cenon", "0603010154", 1, "", "{\"lat\":46.97612885, \"lng\":2.700181263}", "");
		insertUser("Amelie", "Gousset", 4, "img/default.png", "amelie.gousset@mail.com", "67 rue Porte d'Orange", "33150", "Cenon", "0603010155", 0, "", "{\"lat\":46.49496775, \"lng\":3.913780541}", "");
		insertUser("Danielle", "Béland", 4, "img/default.png", "danielle.béland@mail.com", "68 rue Porte d'Orange", "33150", "Cenon", "0603010156", 0, "", "{\"lat\":46.7684091, \"lng\":2.24809213}", "");
		insertUser("Jolie", "Chastain", 4, "img/default.png", "jolie.chastain@mail.com", "69 rue Porte d'Orange", "33150", "Cenon", "0603010157", 0, "", "{\"lat\":46.31351467, \"lng\":3.746980328}", "");
		insertUser("Millard", "Desaulniers", 4, "img/default.png", "millard.desaulniers@mail.com", "5 rue de la République", "69002", "Lyon", "0603010158", 1, "", "{\"lat\":47.72264975, \"lng\":0.3328548942}", "");
		insertUser("Thérèse", "Pitre", 4, "img/default.png", "thérèse.pitre@mail.com", "6 rue de la République", "69002", "Lyon", "0603010159", 1, "", "{\"lat\":45.28550811, \"lng\":0.2651978881}", "");
		insertUser("Orlene", "Bonami", 4, "img/default.png", "orlene.bonami@mail.com", "7 rue de la République", "69002", "Lyon", "0603010160", 1, "", "{\"lat\":48.83512803, \"lng\":3.924361857}", "");
		insertUser("Josephe", "Gingras", 4, "img/default.png", "josephe.gingras@mail.com", "8 rue de la République", "69002", "Lyon", "0603010161", 1, "", "{\"lat\":47.88597549, \"lng\":3.903779903}", "");
		insertUser("Delmare", "Labrosse", 4, "img/default.png", "delmare.labrosse@mail.com", "28 Rue Marie De Médicis", "69002", "Lyon", "0603010162", 0, "", "{\"lat\":45.62938143, \"lng\":0.8385667968}", "");
		insertUser("Yvon", "Chaussée", 4, "img/default.png", "yvon.chaussée@mail.com", "29 Rue Marie De Médicis", "69002", "Lyon", "0603010163", 1, "", "{\"lat\":45.89399247, \"lng\":0.4568556534}", "");
		insertUser("Julie", "Maheu", 4, "img/default.png", "julie.maheu@mail.com", "30 Rue Marie De Médicis", "69002", "Lyon", "0603010164", 1, "", "{\"lat\":48.92658927, \"lng\":3.766010557}", "");
		insertUser("Royce", "Desnoyers", 4, "img/default.png", "royce.desnoyers@mail.com", "20 rue Bonneterie", "12100", "Millau", "0603010165", 1, "", "{\"lat\":48.52430359, \"lng\":2.895491407}", "");
		insertUser("Flora", "Soucy", 4, "img/default.png", "flora.soucy@mail.com", "21 rue Bonneterie", "12100", "Millau", "0603010166", 1, "", "{\"lat\":46.93807183, \"lng\":3.790523415}", "");
		insertUser("Maryse", "Givry", 4, "img/default.png", "maryse.givry@mail.com", "22 rue Bonneterie", "12100", "Millau", "0603010167", 1, "", "{\"lat\":45.91676495, \"lng\":0.6272550926}", "");
		insertUser("Paien", "Fortier", 4, "img/default.png", "paien.fortier@mail.com", "65 rue Michel Ange", "76610", "Le Havre", "0603010168", 1, "", "{\"lat\":47.68198116, \"lng\":2.504672504}", "");
		insertUser("Royce", "Dabigné", 4, "img/default.png", "royce.dabigné@mail.com", "66 rue Michel Ange", "76610", "Le Havre", "0603010169", 0, "", "{\"lat\":45.4876383, \"lng\":0.7275863539}", "");
		insertUser("Bartlett", "Lanoie", 4, "img/default.png", "bartlett.lanoie@mail.com", "67 rue Michel Ange", "76610", "Le Havre", "0603010170", 1, "", "{\"lat\":47.26141578, \"lng\":0.9574269633}", "");
		insertUser("Yseult", "Berthiaume", 4, "img/default.png", "yseult.berthiaume@mail.com", "68 rue Michel Ange", "76610", "Le Havre", "0603010171", 1, "", "{\"lat\":48.74441974, \"lng\":1.864773679}", "");
		insertUser("Sébastien", "Houle", 4, "img/default.png", "sébastien.houle@mail.com", "3 Place de la Gare", "16100", "Cognac", "0603010172", 1, "", "{\"lat\":46.20134625, \"lng\":3.923421281}", "");
		insertUser("Perrin", "Laforest", 4, "img/default.png", "perrin.laforest@mail.com", "4 Place de la Gare", "16100", "Cognac", "0603010173", 1, "", "{\"lat\":46.38854478, \"lng\":0.9567475777}", "");
		insertUser("Odelette", "Berger", 4, "img/default.png", "odelette.berger@mail.com", "5 Place de la Gare", "16100", "Cognac", "0603010174", 0, "", "{\"lat\":48.82689537, \"lng\":1.362103185}", "");
		insertUser("Amedee", "Boisclair", 4, "img/default.png", "amedee.boisclair@mail.com", "55 rue de Raymond Poincaré", "92200", "Neuilly-sur-seine", "0603010175", 0, "", "{\"lat\":45.87796699, \"lng\":1.039302702}", "");
		insertUser("Auriville", "Guédry", 4, "img/default.png", "auriville.guédry@mail.com", "56 rue de Raymond Poincaré", "92200", "Neuilly-sur-seine", "0699085252", 0, "", "{\"lat\":45.57567521, \"lng\":3.438957401}", "");
		insertUser("Bruno", "Berthiaume", 4, "img/default.png", "bruno.berthiaume@mail.com", "57 rue de Raymond Poincaré", "92200", "Neuilly-sur-seine", "0699085253", 0, "", "{\"lat\":48.09426245, \"lng\":2.391770318}", "");
		insertUser("Robinette", "Richard", 4, "img/default.png", "robinette.richard@mail.com", "58 rue de Raymond Poincaré", "92200", "Neuilly-sur-seine", "0699085254", 0, "", "{\"lat\":47.17203431, \"lng\":3.109905313}", "");
		insertUser("Nicholas", "Brisebois", 4, "img/default.png", "nicholas.brisebois@mail.com", "22 Boulevard de Normandie", "92260", "Fontenay-aux-roses", "0699085255", 1, "", "{\"lat\":46.35657099, \"lng\":1.657567832}", "");
		insertUser("Eulalie", "Chevrette", 4, "img/default.png", "eulalie.chevrette@mail.com", "66 rue Descartes", "67200", "Strasbourg", "0699085256", 1, "", "{\"lat\":48.75122993, \"lng\":1.023884077}", "");
		insertUser("Clovis", "Lemieux", 4, "img/default.png", "clovis.lemieux@mail.com", "66 rue Descartes", "67200", "Strasbourg", "0699085257", 0, "", "{\"lat\":47.74733893, \"lng\":3.513457631}", "");
		insertUser("Donatien", "Desjardins", 4, "img/default.png", "donatien.desjardins@mail.com", "34 rue La Boétie", "75017", "Paris", "0699085258", 0, "", "{\"lat\":47.30669448, \"lng\":3.377517468}", "");
		insertUser("Édith", "Bertrand", 4, "img/default.png", "édith.bertrand@mail.com", "99 Boulevard de Normandie", "57600", "Forbach", "0699085259", 0, "", "{\"lat\":45.56248579, \"lng\":2.382755668}", "");
		insertUser("Emmeline", "Perillard", 4, "img/default.png", "emmeline.perillard@mail.com", "95 rue Gontier-Patin", "13090", "Aix-en-provence", "0699085260", 1, "", "{\"lat\":45.2437191, \"lng\":2.359695304}", "");
		insertUser("Etoile", "Forest", 4, "img/default.png", "etoile.forest@mail.com", "95 rue Gontier-Patin", "13090", "Aix-en-provence", "0699085261", 0, "", "{\"lat\":46.67127359, \"lng\":1.754134319}", "");
		insertUser("Liane", "Quinn", 4, "img/default.png", "liane.quinn@mail.com", "91 Rue Roussy", "93130", "Noisy-le-sec", "0699085262", 1, "", "{\"lat\":46.35803863, \"lng\":2.952784251}", "");
		insertUser("Henri", "David", 4, "img/default.png", "henri.david@mail.com", "55 rue des Dunes", "38400", "Saint-martin-d'hÈres", "0699085263", 1, "", "{\"lat\":46.66881279, \"lng\":1.859071739}", "");
		insertUser("Gallia", "Vaillancourt", 4, "img/default.png", "gallia.vaillancourt@mail.com", "62 rue Petite Fusterie", "1000", "Bourg-en-bresse", "0699085264", 1, "", "{\"lat\":48.21795338, \"lng\":1.111102412}", "");
		insertUser("Jacqueline", "Mathieu", 4, "img/default.png", "jacqueline.mathieu@mail.com", "35 rue Jean-Monnet", "95190", "Goussainville", "0699085265", 1, "", "{\"lat\":48.92679576, \"lng\":2.777405666}", "");
		insertUser("Marshall", "Pomerleau", 4, "img/default.png", "marshall.pomerleau@mail.com", "35 rue Jean-Monnet", "95190", "Goussainville", "0699085266", 1, "", "{\"lat\":48.71378318, \"lng\":2.716190165}", "");
		insertUser("Eugène", "Pellerin", 4, "img/default.png", "eugène.pellerin@mail.com", "91 Rue Roussy", "93130", "Noisy-le-sec", "0699085267", 0, "", "{\"lat\":48.99570559, \"lng\":3.481855573}", "");
		insertUser("Marguerite", "Jodoin", 4, "img/default.png", "marguerite.jodoin@mail.com", "62 rue Petite Fusterie", "1000", "Bourg-en-bresse", "0699085268", 1, "", "{\"lat\":46.44860324, \"lng\":0.2123233988}", "");
		insertUser("Nicolette", "Leroux", 4, "img/default.png", "nicolette.leroux@mail.com", "91 Rue Roussy", "93130", "Noisy-le-sec", "0603010193", 1, "", "{\"lat\":45.28440243, \"lng\":3.898784821}", "");
		insertUser("Russell", "Guimond", 4, "img/default.png", "russell.guimond@mail.com", "35 rue Jean-Monnet", "95190", "Goussainville", "0603010194", 1, "", "{\"lat\":48.679368, \"lng\":2.454614707}", "");
		insertUser("Bernard", "Jacques", 4, "img/default.png", "bernard.jacques@mail.com", "68 boulevard Aristide Briand", "6110", "Le Cannet", "0603010195", 1, "", "{\"lat\":46.54064756, \"lng\":0.7538773774}", "");
		insertUser("Varden", "Boisvert", 4, "img/default.png", "varden.boisvert@mail.com", "13 rue de l'Aigle", "17000", "La Rochelle", "0603010196", 1, "", "{\"lat\":46.67768618, \"lng\":3.055959735}", "");
		insertUser("Delphine", "Poissonnier", 4, "img/default.png", "delphine.poissonnier@mail.com", "68 boulevard Aristide Briand", "6110", "Le Cannet", "0603010197", 0, "", "{\"lat\":46.37878129, \"lng\":0.7878148159}", "");
		insertUser("Garland", "Brousse", 4, "img/default.png", "garland.brousse@mail.com", "95 rue Gontier-Patin", "13090", "Aix-en-provence", "0603010198", 0, "", "{\"lat\":48.66466625, \"lng\":1.397987908}", "");
		insertUser("Joy", "Bonsaint", 4, "img/default.png", "joy.bonsaint@mail.com", "62 rue Petite Fusterie", "1000", "Bourg-en-bresse", "0603010199", 1, "", "{\"lat\":48.94842604, \"lng\":0.8684407823}", "");
		insertUser("Tearlach", "Sarrazin", 4, "img/default.png", "tearlach.sarrazin@mail.com", "13 rue de l'Aigle", "17000", "La Rochelle", "0603010194", 1, "", "{\"lat\":46.8844064, \"lng\":2.475086588}", "");
		
		//Insert credentials
		Credentials credentials1 = insertCredentials("login1", "pwd1");
		Credentials credentials2 = insertCredentials("login2", "pwd2");

		//Link user to credentials
		addCredentialsToUser(1, credentials1.getId());
		addCredentialsToUser(2, credentials2.getId());

		// Insert proposals
		insertProposal("Bricolage, petit travaux", "Bricoleur habitué à monter des poignées de cuisine sur petite cuisine aménagée, je propose mes services.", "bricolage.png", 50, 35, 2);
		insertProposal("Bricolage, petit travaux", "Je suis une personne compétente pour remplacer le carrelage, n'hésitez pas, je suis disponible immédiatement.", "bricolage.png", 40, 35, 2);
		insertProposal("Bricolage, petit travaux", "Sérieux, disponible, je suis à votre service pour tout petit boulot du weekend.", "bricolage.png", 20, 35, 1);
		insertProposal("Bricolage, petit travaux", "Bon bricoleur, capable de monter un moteur de store électrique Somfy.", "bricolage.png", 50, 35, 1);
		insertProposal("Bricolage, petit travaux", "Organisé et débrouillard , j'ai travaillé comme peintre, électricien et plaquiste.", "bricolage.png", 20, 35, 2);
		insertProposal("Bricolage, petit travaux", "Humblement à votre disposition pour tous types de travaux.", "bricolage.png", 35, 35, 2);
		insertProposal("Jardinage", "Je suis qualifié, diplômé, et j'ai de l'expérience dans le domaine des espaces verts.", "jardinage.png", 40, 31, 2);
		insertProposal("Jardinage", "Je recherche du travail en espaces verts, en extérieur ou en intérieur. ", "jardinage.png", 20, 31, 1);
		insertProposal("Jardinage", " Dépanneur systèmes d'arrosage, je suis disponible et à l'écoute.", "jardinage.png", 15, 31, 12);
		insertProposal("Jardinage", "Je propose mes services pour l'entretien de votre jardin.", "jardinage.png", 30, 31, 20);
		insertProposal("Jardinage", "Aide jardinier disponible immédiatement et à votre disposition.", "jardinage.png", 15, 31, 19);
		insertProposal("Garde d'enfants", "J’ai une formation dans le baby-sitting j’aime m’occuper des enfants etsuis une grande amoureuse des animaux ! Étant véhiculé j’ai la possibilité de me déplacer ", "garde_enfant.png", 12, 12, 29);
		insertProposal("Garde d'enfants", "En tant qu’étudiante de 19 ans je vous propose mes services dans divers domaines tels que le ménage, la garde de vos enfants et de vos animaux.", "garde_enfant.png", 12, 12, 39);
		insertProposal("Garde d'enfants", "J' ai mon bep carrières sanitaires et sociales et mon cap petite enfance. Je garde des enfants depuis plus de 10 ans. Je suis disponible , le week end, pendant les vacances et à partir de juillet tout le temps.", "garde_enfant.png", 12, 12, 27);
		insertProposal("Garde d'enfants", " Je fais du babysitting, du soutien scolaire spécialement en mathématiques et en sciences, j'ai été serveuse pendant 5 ans à côté de mes études. ", "garde_enfant.png", 12, 12, 98);
		insertProposal("Garde d'enfants", "Habituée aux baby sitting pour enfants de tous âges je vous propose mes services en toute sécurité je peux me rendre disponible facilement.", "garde_enfant.png", 12, 12, 9);
		insertProposal("Coiffure", "Coiffeuse à domicile ou en déplacement, disponible et efficace.", "bien_etre.png", 20, 5, 79);
		insertProposal("Soins esthétiques", "Esthéticienne certifiée et spécialisée dans les publics fragiles (profession para médicale reconnue comme soin de support en oncologie), les soins que je propose sont adaptés à la personne et à sa situation.", "bien_etre.png", 35, 4, 72);
		insertProposal("Soins esthétiques", "Coucou les filles , je vous propose le rehaussement des cils qui sublimera votre regard. Avec teinture si vous le souhaitez. Le rehaussement dure entre 2 et 3 mois. ", "bien_etre.png", 30, 4, 14);
		insertProposal("Soins esthétiques", "Je vous propose des soins esthétiques de qualité avec des produits professionnels (épilation toutes zones, soins de mains et des pieds, maquillage, conseils en image), je suis aussi prothésiste ongulaire.", "bien_etre.png", 60, 4, 39);
		insertProposal("Massage", "Masseuse expérimentée et délicate, je propose des massages de 30min à 2h à petits prix.", "bien_etre.png", 50, 2, 12);
		insertProposal("Soins esthétiques", "Esthéticienne à domicile passionnée et diplômée depuis plus de 10ans. Je vous propose un moment de detente privilégié sans bouger de chez vous", "bien_etre.png", 30, 4, 74);
		insertProposal("Soins esthétiques", "Je suis Esthéticienne depuis maintenant plus de 6 ans. Je propose mes services à mon domicile.", "bien_etre.png", 25, 4, 22);
		insertProposal("Garde d'enfants", "J'ai mon bep carrières sanitaires et sociales et mon cap petite enfance. Je garde des enfants depuis plus de 10 ans. Je suis disponible , le week end, pendant les vacances et à partir de juillet tout le temps.", "garde_enfant.png", 20, 12, 55);
		insertProposal("Aide au déménagement", "Jeune père de famille aimant la vie, je prends plaisir à aider les personnes sollicitent mes services. Je possède un camion 12m3 adapté à toute sorte de missions.", "demenagement.png", 10, 15, 28);
		insertProposal("Aide au déménagement", "Je souhaite proposer mes services. Mes amis me décrivent comme une personne serviable, bricoleur et patient. ", "demenagement.png", 16, 15, 13);
		insertProposal("Aide au déménagement", "Disponible sur Paris et alentours pour travaux variés, quelques heures en semaine et le week-end pour compléter mes revenus. : déménagements, manutention, etc..)", "demenagement.png", 30, 15, 68);
		insertProposal("Aide au déménagement", " je suis disponible pour votre déménagement transport à votre disposition 3 camion 10. 15 et 22m3 entièrement équipé pour les déménagements couverture de protection, diable, sangle, plateau roulant,chariot capacité 200kg.", "demenagement.png", 18, 15, 41);
		insertProposal("Aide au déménagement", "Grand professionnel, actif et très motivé, je suis disponible pour vous aider dans vos déménagements principalement puisque je dispose de mes propres camions (2 fois 22m3).", "demenagement.png", 20, 15, 27);
		insertProposal("Assistance aux personnes âgées", "Infirmière à mi-temps s'occupe des personnes âgées à domicile : soins basiques, courses, toilette,...", "assistance.png", 45, 13, 58);
		insertProposal("Assistance aux personnes âgées", "Etudiante en pharmacie est disponible pour apporter aide et compagnie aux personnes qui en ont besoin", "assistance.png", 40, 13, 59);
		insertProposal("Assistance informatique", "Aide pour utiliser un ordinateur : bureautique, emails, naviguer sur internet,...", "informatique.png", 10, 14, 76);
		insertProposal("Assistance informatique", "Je créé des sites internet sur mesure pour votre boutique en ligne, votre portefolio, votre blog...", "informatique.png", 30, 14, 60);
		insertProposal("Photographie et vidéo", "Photographie de mariage, évenements d'entreprise, anniversaires...", "photo.png", 80, 21, 79);
		insertProposal("Photographie et vidéo", "Photographe passioné (tout type), je propose mes services en région parisienne", "photo.png", 40, 21, 95);
		insertProposal("Photographie et vidéo", "Photographe et vidéaste confirmé pour tous projets sérieux", "photo.png", 40, 21, 77);
		insertProposal("Musique et son", "Propose cours de piano à domicile, tout âge et tous niveaux", "musique.png", 35, 22, 57);
		insertProposal("Musique et son", "Cours de piano et de solfège pour débutants", "musique.png", 42, 22, 35);
		insertProposal("Musique et son", "Prestation DJ, karaoke pour tous types d'événements. Location de matériel possible", "musique.png", 100, 22, 67);
		insertProposal("Musique et son", "Professeur en conservatoire de violon propose cours à domicile tous niveaux", "musique.png", 50, 22, 71);
		insertProposal("Illustration et infographie", "Etudiant en infographie propose ses services pour création de logos, de charte graphique, réalisation de site webs...", "infographie.png", 30, 23, 11);
		insertProposal("Arts plastiques", "Cours de menuiserie en groupe. 3 niveaux (débutant, intermédiaire, avancé).", "arts_plastiques.png", 28, 24, 100);
		insertProposal("Arts numériques et multimédia", "J'anime chaque week end des projections de films cultes suivis de discussions généralement animées autour d'un cocktail. Rejoignez-nous!", "multimedia.png", 5, 25, 14);
		insertProposal("Jardinage", "Jardinier passionné pour l'entretien du jardin de particuliers", "jardinage.png", 15, 31, 70);
		insertProposal("Jardinage", "Je propose ma main verte et mon entrain pour faire de votre jardin un coin de paradis", "jardinage.png", 12, 31, 54);
		insertProposal("Jardinage", "TONDRE LA PELOUSE, TAILLAGE HAIE ETC PLUS DINFOS MP", "jardinage.png", 1, 31, 18);
		insertProposal("Arts et création", "Je réalise des pièces au crochet sur mesure et propose également des cours individuels", "arts.png", 10, 20, 37);
		insertProposal("Arts et création", "Cours de poterie en groupe tous niveaux", "arts.png", 35, 20, 80);
		insertProposal("Plomberie", "Professionel consciencieux pour plomberie", "plomberie.png", 50, 36, 53);
		insertProposal("Lavage automobile", "Passionné moto et auto, j'entretiens votre véhicule avec soin. dispo WE", "automobile.png", 15, 34, 91);
		insertProposal("Lavage automobile", "Lavage et entretien (contrôle technique) rapide efficace", "automobile.png", 12, 34, 4);
		insertProposal("Ménage", "Je fais des ménages, repassage je suis véhiculée.", "menage.png", 10, 33, 2);
		insertProposal("Ménage", "Je vous propose mes services pour faire le ménage dans votre domicile, je suis très sérieuse, consciencieuse, très attentionné, efficace, dynamique.", "menage.png", 11, 33, 46);
		insertProposal("Ménage", "J'ai déjà travaillé en tant qu'aide ménagère pendant 5 ans dans une hôtel, repassage, aspirateur, hygiène général. ", "menage.png", 11, 33, 78);
		insertProposal("Ménage", "Après avoir obtenu mon diplôme ADVF, j'ai occupé un poste en qualité d'agent à domicile pendant 3 ans suite à cela, j'ai décidé de créer ma propre société de service à la personne.", "menage.png", 13, 33, 92);
		insertProposal("Ménage", "De nature maniaque et pointilleuse, je réalise vos travaux de ménage, repassage et nettoyage. Je connais également pleins de petites astuces écologique et économiques.", "menage.png", 10, 33, 10);
		insertProposal("Plomberie", "Je suis disponible pour tous travaux de la maison peinture, plomberie, montage de meubles, faïence, parquet, rénovation.", "plomberie.png", 10, 36, 52);
		insertProposal("Plomberie", "J'aide les personnes démunies face à un petit problème ,et évite les abus ou des dépenses (très) importantes lors d'interventions comme plomberie ou serrurerie .", "plomberie.png", 12, 36, 24);
		insertProposal("Plomberie", "Expérience plomberie \"domestique\". Connaissance forte des produits chimiques adaptés / outillage classique pour changements joints courants.", "plomberie.png", 13, 36, 18);
		insertProposal("Plomberie", "Je suis plombier chauffagiste de métier, j’ai les compétences nécessaires pour tous types d’installation, dépannage et rénovation.", "plomberie.png", 11, 36, 20);
		insertProposal("Eléctricité", "Je suis quelqu’un de polyvalent, électrotechnicien de formation, habile de mes mains, je monte et démonte, fixe tout type de mobilier, je décolle, et colle du papier peint.", "electricite.png", 10, 37, 83);
		insertProposal("Eléctricité", "Je suis disponible cette semaine mais aussi tous les soirs et les weekends , pour le bricolage (électricité ..)", "electricite.png", 15, 37, 92);
		insertProposal("Eléctricité", "Électricien professionnel diplômé (bep,bac électrotechnique) et expérimenté (+10 ans). Installation,dépannage,mise aux normes,conseil.", "electricite.png", 12, 37, 6);
		insertProposal("Eléctricité", "Etant électricien de formation ,avec une forte compétence dans ce domaine ,je me ferai un grand plaisir de pouvoir vous aider .", "electricite.png", 12, 37, 64);

// Random users...
		insertProposal("Bricolage, petit travaux", "Bricoleur habitué à monter des poignées de cuisine sur petite cuisine aménagée, je propose mes services.", "bricolage.png", 50, 35, 99);
		insertProposal("Bricolage, petit travaux", "Je suis une personne compétente pour remplacer le carrelage, n'hésitez pas, je suis disponible immédiatement.", "bricolage.png", 40, 35, 105);
		insertProposal("Bricolage, petit travaux", "Sérieux, disponible, je suis à votre service pour tout petit boulot du weekend.", "bricolage.png", 20, 35, 88);
		insertProposal("Bricolage, petit travaux", "Bon bricoleur, capable de monter un moteur de store électrique Somfy.", "bricolage.png", 50, 35, 83);
		insertProposal("Bricolage, petit travaux", "Organisé et débrouillard , j'ai travaillé comme peintre, électricien et plaquiste.", "bricolage.png", 20, 35, 95);
		insertProposal("Bricolage, petit travaux", "Humblement à votre disposition pour tous types de travaux.", "bricolage.png", 35, 35, 104);
		insertProposal("Jardinage", "Je suis qualifié, diplômé, et j'ai de l'expérience dans le domaine des espaces verts.", "jardinage.png", 40, 31, 182);
		insertProposal("Jardinage", "Je recherche du travail en espaces verts, en extérieur ou en intérieur. ", "jardinage.png", 20, 31, 142);
		insertProposal("Jardinage", " Dépanneur systèmes d'arrosage, je suis disponible et à l'écoute.", "jardinage.png", 15, 31, 152);
		insertProposal("Jardinage", "Je propose mes services pour l'entretien de votre jardin.", "jardinage.png", 30, 31, 194);
		insertProposal("Jardinage", "Aide jardinier disponible immédiatement et à votre disposition.", "jardinage.png", 15, 31, 161);
		insertProposal("Garde d'enfants", "J’ai une formation dans le baby-sitting j’aime m’occuper des enfants etsuis une grande amoureuse des animaux ! Étant véhiculé j’ai la possibilité de me déplacer ", "garde_enfant.png", 12, 12, 66);
		insertProposal("Garde d'enfants", "En tant qu’étudiante de 19 ans je vous propose mes services dans divers domaines tels que le ménage, la garde de vos enfants et de vos animaux.", "garde_enfant.png", 12, 12, 67);
		insertProposal("Garde d'enfants", "J' ai mon bep carrières sanitaires et sociales et mon cap petite enfance. Je garde des enfants depuis plus de 10 ans. Je suis disponible , le week end, pendant les vacances et à partir de juillet tout le temps.", "garde_enfant.png", 12, 12, 68);
		insertProposal("Garde d'enfants", " Je fais du babysitting, du soutien scolaire spécialement en mathématiques et en sciences, j'ai été serveuse pendant 5 ans à côté de mes études. ", "garde_enfant.png", 12, 12, 69);
		insertProposal("Garde d'enfants", "Habituée aux baby sitting pour enfants de tous âges je vous propose mes services en toute sécurité je peux me rendre disponible facilement.", "garde_enfant.png", 12, 12, 78);
		insertProposal("Coiffure", "Coiffeuse à domicile ou en déplacement, disponible et efficace.", "bien_etre.png", 20, 5, 84);
		insertProposal("Soins esthétiques", "Esthéticienne certifiée et spécialisée dans les publics fragiles (profession para médicale reconnue comme soin de support en oncologie), les soins que je propose sont adaptés à la personne et à sa situation.", "bien_etre.png", 35, 4, 153);
		insertProposal("Soins esthétiques", "Coucou les filles , je vous propose le rehaussement des cils qui sublimera votre regard. Avec teinture si vous le souhaitez. Le rehaussement dure entre 2 et 3 mois. ", "bien_etre.png", 30, 4, 155);
		insertProposal("Soins esthétiques", "Je vous propose des soins esthétiques de qualité avec des produits professionnels (épilation toutes zones, soins de mains et des pieds, maquillage, conseils en image), je suis aussi prothésiste ongulaire.", "bien_etre.png", 60, 4, 157);
		insertProposal("Massage", "Masseuse expérimentée et délicate, je propose des massages de 30min à 2h à petits prix.", "bien_etre.png", 50, 2, 158);
		insertProposal("Soins esthétiques", "Esthéticienne à domicile passionnée et diplômée depuis plus de 10ans. Je vous propose un moment de detente privilégié sans bouger de chez vous", "bien_etre.png", 30, 4, 167);
		insertProposal("Soins esthétiques", "Je suis Esthéticienne depuis maintenant plus de 6 ans. Je propose mes services à mon domicile.", "bien_etre.png", 25, 4, 176);
		insertProposal("Garde d'enfants", "J'ai mon bep carrières sanitaires et sociales et mon cap petite enfance. Je garde des enfants depuis plus de 10 ans. Je suis disponible , le week end, pendant les vacances et à partir de juillet tout le temps.", "garde_enfant.png", 20, 12, 190);
		insertProposal("Aide au déménagement", "Jeune père de famille aimant la vie, je prends plaisir à aider les personnes sollicitent mes services. Je possède un camion 12m3 adapté à toute sorte de missions.", "demenagement.png", 10, 15, 192);
		insertProposal("Aide au déménagement", "Je souhaite proposer mes services. Mes amis me décrivent comme une personne serviable, bricoleur et patient. ", "demenagement.png", 16, 15, 163);
		insertProposal("Aide au déménagement", "Disponible sur Paris et alentours pour travaux variés, quelques heures en semaine et le week-end pour compléter mes revenus. : déménagements, manutention, etc..)", "demenagement.png", 30, 15, 113);
		insertProposal("Aide au déménagement", " je suis disponible pour votre déménagement transport à votre disposition 3 camion 10. 15 et 22m3 entièrement équipé pour les déménagements couverture de protection, diable, sangle, plateau roulant,chariot capacité 200kg.", "demenagement.png", 18, 15, 127);
		insertProposal("Aide au déménagement", "Grand professionnel, actif et très motivé, je suis disponible pour vous aider dans vos déménagements principalement puisque je dispose de mes propres camions (2 fois 22m3).", "demenagement.png", 20, 15, 188);
		insertProposal("Assistance aux personnes âgées", "Infirmière à mi-temps s'occupe des personnes âgées à domicile : soins basiques, courses, toilette,...", "assistance.png", 45, 13, 143);
		insertProposal("Assistance aux personnes âgées", "Etudiante en pharmacie est disponible pour apporter aide et compagnie aux personnes qui en ont besoin", "assistance.png", 40, 13, 135);
		insertProposal("Assistance informatique", "Aide pour utiliser un ordinateur : bureautique, emails, naviguer sur internet,...", "informatique.png", 10, 14, 125);
		insertProposal("Assistance informatique", "Je créé des sites internet sur mesure pour votre boutique en ligne, votre portefolio, votre blog...", "informatique.png", 30, 14, 165);
		insertProposal("Photographie et vidéo", "Photographie de mariage, évenements d'entreprise, anniversaires...", "photo.png", 80, 21, 110);
		insertProposal("Photographie et vidéo", "Photographe passioné (tout type), je propose mes services en région parisienne", "photo.png", 40, 21, 103);
		insertProposal("Photographie et vidéo", "Photographe et vidéaste confirmé pour tous projets sérieux", "photo.png", 40, 21, 151);
		insertProposal("Musique et son", "Propose cours de piano à domicile, tout âge et tous niveaux", "musique.png", 35, 22, 180);
		insertProposal("Musique et son", "Cours de piano et de solfège pour débutants", "musique.png", 42, 22, 119);
		insertProposal("Musique et son", "Prestation DJ, karaoke pour tous types d'événements. Location de matériel possible", "musique.png", 100, 22, 137);
		insertProposal("Musique et son", "Professeur en conservatoire de violon propose cours à domicile tous niveaux", "musique.png", 50, 22, 168);
		insertProposal("Illustration et infographie", "Etudiant en infographie propose ses services pour création de logos, de charte graphique, réalisation de site webs...", "infographie.png", 30, 23, 112);
		insertProposal("Arts plastiques", "Cours de menuiserie en groupe. 3 niveaux (débutant, intermédiaire, avancé).", "arts_plastiques.png", 28, 24, 151);
		insertProposal("Arts numériques et multimédia", "J'anime chaque week end des projections de films cultes suivis de discussions généralement animées autour d'un cocktail. Rejoignez-nous!", "multimedia.png", 5, 25, 133);
		insertProposal("Jardinage", "Jardinier passionné pour l'entretien du jardin de particuliers", "jardinage.png", 15, 31, 170);
		insertProposal("Jardinage", "Je propose ma main verte et mon entrain pour faire de votre jardin un coin de paradis", "jardinage.png", 12, 31, 183);
		insertProposal("Jardinage", "TONDRE LA PELOUSE, TAILLAGE HAIE ETC PLUS DINFOS MP", "jardinage.png", 1, 31, 119);
		insertProposal("Arts et création", "Je réalise des pièces au crochet sur mesure et propose également des cours individuels", "arts.png", 10, 20, 175);
		insertProposal("Arts et création", "Cours de poterie en groupe tous niveaux", "arts.png", 35, 20, 117);
		insertProposal("Plomberie", "Professionel consciencieux pour plomberie", "plomberie.png", 50, 36, 150);
		insertProposal("Lavage automobile", "Passionné moto et auto, j'entretiens votre véhicule avec soin. dispo WE", "automobile.png", 15, 34, 153);
		insertProposal("Lavage automobile", "Lavage et entretien (contrôle technique) rapide efficace", "automobile.png", 12, 34, 178);
		insertProposal("Ménage", "Je fais des ménages, repassage je suis véhiculée.", "menage.png", 10, 33, 150);
		insertProposal("Ménage", "Je vous propose mes services pour faire le ménage dans votre domicile, je suis très sérieuse, consciencieuse, très attentionné, efficace, dynamique.", "menage.png", 11, 33, 148);
		insertProposal("Ménage", "J'ai déjà travaillé en tant qu'aide ménagère pendant 5 ans dans une hôtel, repassage, aspirateur, hygiène général. ", "menage.png", 11, 33, 151);
		insertProposal("Ménage", "Après avoir obtenu mon diplôme ADVF, j'ai occupé un poste en qualité d'agent à domicile pendant 3 ans suite à cela, j'ai décidé de créer ma propre société de service à la personne.", "menage.png", 13, 33, 120);
		insertProposal("Ménage", "De nature maniaque et pointilleuse, je réalise vos travaux de ménage, repassage et nettoyage. Je connais également pleins de petites astuces écologique et économiques.", "menage.png", 10, 33, 182);
		insertProposal("Plomberie", "Je suis disponible pour tous travaux de la maison peinture, plomberie, montage de meubles, faïence, parquet, rénovation.", "plomberie.png", 10, 36, 137);
		insertProposal("Plomberie", "J'aide les personnes démunies face à un petit problème ,et évite les abus ou des dépenses (très) importantes lors d'interventions comme plomberie ou serrurerie .", "plomberie.png", 12, 36, 146);
		insertProposal("Plomberie", "Expérience plomberie \"domestique\". Connaissance forte des produits chimiques adaptés / outillage classique pour changements joints courants.", "plomberie.png", 13, 36, 148);
		insertProposal("Réseaux sociaux", "Je suis plombier chauffagiste de métier, j’ai les compétences nécessaires pour tous types d’installation, dépannage et rénovation.", "plomberie.png", 11, 51, 140);
		insertProposal("Programmation", "Je suis quelqu’un de polyvalent, électrotechnicien de formation, habile de mes mains, je monte et démonte, fixe tout type de mobilier, je décolle, et colle du papier peint.", "electricite.png", 10, 53, 124);
		insertProposal("Programmation", "Je suis disponible cette semaine mais aussi tous les soirs et les weekends , pour le bricolage (électricité ..)", "electricite.png", 15, 53, 167);
		insertProposal("Installation d'un ordinateur", "Électricien professionnel diplômé (bep,bac électrotechnique) et expérimenté (+10 ans). Installation,dépannage,mise aux normes,conseil.", "electricite.png", 12, 54, 152);
		insertProposal("Installation d'un ordinateur", "Etant électricien de formation ,avec une forte compétence dans ce domaine ,je me ferai un grand plaisir de pouvoir vous aider .", "electricite.png", 12, 53, 127);

		// Insert services
		insertPrestation(1, false, 39, 1, 1, 1, 3, 0);
		insertPrestation(2, false, 60, 2, 1, 1, 3, 5);
		insertPrestation(3, false, 11, 1, 0, 1, 5, 0);
		insertPrestation(4, false, 16, 1, 0, 1, 2, 4);
		insertPrestation(5, false, 38, 1, 1, 1, 1, 2);
		insertPrestation(6, false, 13, 2, 0, 1, 3, 5);
		insertPrestation(7, false, 45, 2, 0, 0, 2, 5);
		insertPrestation(8, false, 31, 2, 0, 1, 5, 0);
		insertPrestation(9, false, 40, 21, 0, 0, 4, 4);
		insertPrestation(10, false, 16, 65, 1, 1, 1, 4);
		insertPrestation(11, false, 35, 82, 1, 1, 5, 0);
		insertPrestation(12, false, 5, 84, 1, 0, 2, 5);
		insertPrestation(13, false, 49, 17, 1, 0, 4, 3);
		insertPrestation(14, false, 1, 57, 1, 0, 5, 4);
		insertPrestation(15, false, 32, 93, 1, 1, 3, 5);
		insertPrestation(16, false, 33, 54, 0, 1, 1, 2);
		insertPrestation(17, false, 29, 87, 0, 0, 4, 1);
		insertPrestation(18, false, 38, 81, 0, 0, 0, 1);
		insertPrestation(19, false, 32, 11, 1, 0, 0, 3);
		insertPrestation(20, false, 12, 26, 0, 0, 5, 1);
		insertPrestation(21, false, 15, 70, 0, 1, 0, 1);
		insertPrestation(22, false, 36, 45, 0, 0, 2, 3);
		insertPrestation(23, false, 29, 32, 1, 1, 0, 0);
		insertPrestation(24, false, 5, 43, 0, 1, 1, 0);
		insertPrestation(25, false, 38, 87, 0, 1, 2, 0);
		insertPrestation(26, false, 32, 70, 0, 1, 3, 3);
		insertPrestation(27, false, 33, 62, 0, 1, 2, 1);
		insertPrestation(28, false, 39, 14, 1, 1, 2, 5);
	}

	private void insertPrestation(int id, boolean valide, int proposalId, int customerId, int finished, int cancelled, int ratingClient, int ratingProvider) {
		Prestation prestation = new Prestation();
		prestation.setId(id);
		prestation.setValide(valide);
		prestation.setProposal(proposalRepository.findById(proposalId).orElse(null));
		prestation.setCustomer(userRepository.findById(customerId).orElse(null));
		prestation.setCancelled(cancelled == 1 && finished != 1);
		prestation.setDelivered(finished == 1);
		prestation.setCustomerRating(ratingClient);
		prestation.setProviderRating(ratingProvider);

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(2020, Calendar.JANUARY, 1);
		Date d1 = new Date(calendar.getTime().getTime());
		calendar.set(2020, Calendar.APRIL, 1);
		Date d2 = new Date(calendar.getTime().getTime());

		Date randomDate1 = new Date(ThreadLocalRandom.current()
				.nextLong(d1.getTime(), d2.getTime()));

		Date randomDate2 = new Date(ThreadLocalRandom.current()
				.nextLong(d1.getTime(), new Date().getTime()));

		prestation.setStartDate(randomDate1);

		if (finished == 1) {
			prestation.setEndDate(randomDate2);
		}

		prestationRepository.save(prestation);
	}

	private void insertProposal(String name, String description, String picture, int price, int categoryId, int userId) {
		Proposal proposal = new Proposal();
		proposal.setName(name);
		proposal.setDescription(description);
		proposal.setImage(picture);
		proposal.setPrice((double)price);
		proposal.setCategory(categoryRepository.findById(categoryId).orElse(null));
		proposal.setProvider(userRepository.findById(userId).orElse(null));
		proposal.setMaxDistance(Math.random() * 10 + 5);

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(2020, Calendar.JANUARY, 1);
		Date randomDate = new Date(ThreadLocalRandom.current()
				.nextLong(calendar.getTime().getTime(), new Date().getTime()));
		proposal.setDate(randomDate);

		proposalRepository.save(proposal);
	}

	private void insertUser(String firstName, String lastName, float globalRating, String image, String email, String address, String postalCode,
							  String city, String phone, int premium, String registrationNumber, String geoloc, String gender) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGlobalRating((float)Math.random() * 2.5f + 2.5f);
		user.setImage(image);
		user.setEmail(email);
		user.setAddress(address);
		user.setPostCode(postalCode);
		user.setCity(city);
		user.setPhoneNumber(phone);
		user.setPremium(premium == 1);
		user.setRegistrationNumber(registrationNumber);
		user.setRole(UserRole.DEFAULT);
		user.setGeolocation(geoloc);

		userRepository.save(user);
	}

	private Category insertCategory(int id, String name, String picture) {
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setCategory(null);
		category.setImage(picture);

		return categoryRepository.save(category);
	}

	private Category insertCategory(int id, String name, Category parentCategory) {
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setCategory(parentCategory);
		category.setImage(parentCategory.getImage());

		return categoryRepository.save(category);
	}

	private Credentials insertCredentials(String login, String password) throws NoSuchAlgorithmException {
		String hashPassword = credentialsService.hash(password);
		Credentials credentials = new Credentials();
		credentials.setLogin(login);
		credentials.setHashedPassword(hashPassword);
		return credentialsRepository.save(credentials);
	}

	private void addCredentialsToUser(Integer idUser, Integer idCredentials) {
		User user = userRepository.findById(idUser).get();
		Credentials credentials = credentialsRepository.findById(idCredentials).get();
		user.setCredentials(credentials);
		user = userRepository.save(user);
		credentials.setUser(user);
		credentials = credentialsRepository.save(credentials);
		userRepository.save(user);
		System.out.println("===================== " + user.getCredentials().getLogin()+ " id= " + user.getId());
	}
}
