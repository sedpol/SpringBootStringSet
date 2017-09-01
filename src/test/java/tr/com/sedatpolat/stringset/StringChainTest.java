package tr.com.sedatpolat.stringset;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import tr.com.sedatpolat.stringset.util.StringChain;

/**
 * 
 * @author sedpol
 *
 */
public class StringChainTest {
	private final String[] STRING_EMPTY = {};
	private final String[] STRING_EASY = { "abc", "fgh", "cde", "cdf", "fuf" };
	private final String[] STRING_EASY2 = { "ps", "sugar", "rice", "soup" };
	private final String[] STRING_STRESS = { "13coo", "13ot2gip01", "13p9pv562onpdbcanl52r6uo78",
			"18atpiaiukq82q6pkjst0ql6vm2mh", "1aak6tjddjvn8d5u", "1f01kl2eeja56", "1ftj11240o", "1ftmed835h213",
			"1g5tki3ehmf9cl8srd9f4tvbjp32mmd4fqv1a3", "1gd8eips7fbeqm8", "1gj1101ptlps1d6drennvpu67lo2suj8jk9lkedsf",
			"1k14anr6et01gj", "1kgn3l1cpklihnvr30", "1l5e6ee6m4plh8", "1qbkkdktvo4tfc6", "1r9gjrpdp839",
			"201lbstu9io1febod4mcvo6bqo9kcr1hjg9ba8k263", "21l1blgthlhh1na7dcuarto3hb5f",
			"223lf1v8biem40vlha22k2q6hjv41hl2", "22rvce9blkpr00os5", "2e3ho4vev86guhrl35i0nob4b088e5ko4eqcp",
			"2ep2s069m36435efubi4e5o1591fkr3957fj3gj6", "2m0sse5k0i99aei6jf", "2ms4qm4d2fkv7svkjqn69",
			"2t71ecg04248m8uvi672ch", "335u9ei95bu0kqac0pahj2024m7f6g79cg", "36dk4spej2b7fi51huh6hpbv", "38pojhfof0hq",
			"3ai1h9pj8nkemvcgldoecaqpiasgrbnq7emo5v6t4", "3beshaddip5v5oqt9rctc", "3f922074ol4u2b0l5j",
			"3foiti9ff6hd6ee5a002jc26mhf4qk", "3hiu", "3kbklv9cml6khla", "3l38svqi134m5l34i3fp6d8pord0m",
			"3m9iis4ff5u8jcg16qg583dai874e3uveph5hhkc", "3mngm7804fa02rt4vkgdcbhgbi6gvn1", "3pnflvnn", "3qdd8o5",
			"3qpa44iuc2nquco8ktfmc93349cl0r", "3su8rtgo08j3e1kga94avrepbo2c5qoo", "42mapr7po7al",
			"48an9q6qrtnq550br0g4d3n9dcoq", "48d9v", "4ctpqb24o1j", "4eluqehmd", "4moecknh8fp9tko0bu4mr672s3",
			"58i1ti6gc", "63ami97rak18r8ktp28", "66tm6", "6926dmp22vu6pooqkhaic3p5p7o3uqk", "6t82cgl5g", "6vbr9",
			"72p8kq2lvvk2", "77e49vtkcsm9aphmc92gev", "7a4", "7hj4prq9t1c8", "7m1q6oiusgflri5rk2slahjgp7frisgbc7",
			"8s1d11u2", "8s45ks56e83ce42sruurmfsjn2co52v5m07g6", "95n07mcj80n80ncl4kabge74oaknh49ko",
			"9im8lb95i59rjit0a", "a488ochlc61q533tqrc3f8rn", "ao", "bs21gil1mmclfc293620c",
			"clr687k2gjvolc09q2ju5oasvbtts17", "d4k7k4m610ft8c3r7v781rmo0s3k8hbeb4lgm", "dffvtidke7a8biq",
			"e16oaloqg0tbkg9q4rds15hasgm", "el5604leu90pdab0csdg6e2bb5vc4l2756dod8qm", "emij5i3dtt07i2aobr4j",
			"f0sn4a6sr09df01nlecla6dancv26", "f6d92jniq", "gmami9ak5em89n7p1p18", "gnindsfkb1137gp",
			"gqrcii6m80kk74qajrm02mp", "h0eehigl303vs7qshuhimucso5m14cr5", "hg283snhhjq4i1b17109kd76",
			"hn7u5ltj5nhkqa88frj8jbrm48", "i2n2m7j8enubdfu9msc001orff6", "i6ja5fvkvqrfgslvr3iav",
			"itfan26c3i2af1uqfv4rr63g7bm1t", "jgesk9nj6", "jtcdc6ei5304i69dkic6tg2pr",
			"k5f742995gtgtcus5jobkc088paa83tgm336fcikl", "kc4fedl5fd2", "kv8s8bf8kj", "lk5hj6niko0ufaoib9dasq1c8fjkeca",
			"n0ir8j7src7mpabptcfcovsnbshvq7r771d2frh9b", "npre765vt3vev77da4", "ol11343ifkhr5seamjgi1",
			"onrv80ckqc6tahjmeqoskdf", "p8pm0g9g3445gu3b4e8uf7p", "rfsu1", "ske76ri9irb74j8nvt9nfvum4modgvlj", "tevko",
			"un1o250rvgj", "uplsbjeq4449tkkcpa8jg48fg2v0g0tseg", "v2almf5aqsas06bvai", "vm40926te83cartthuo2cj1ofn7d",
			"voubkpsvpk36dktsndm80" };

	@Test
	public void isChainCase() {
		StringChain chain = new StringChain();

		assertEquals(true, isChain(chain.findMaxChain(STRING_EMPTY)));
		assertEquals(true, isChain(chain.findMaxChain(STRING_EASY)));
		assertEquals(true, isChain(chain.findMaxChain(STRING_EASY2)));
		assertEquals(true, isChain(chain.findMaxChain(STRING_STRESS)));
	}

	public boolean isChain(List<String> list) {
		System.out.println(list);
		for (int i = 0; i < list.size() - 1; i++) {
			if (!list.get(i).endsWith(list.get(i + 1).substring(0, 1)))
				return false;
		}
		return true;
	}
}
