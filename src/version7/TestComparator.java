package version7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.NullComparator;

import bean.TestDataBean;

public class TestComparator {


	public void executeComparator() {


		//ConparatorChainテスト
		this.testCommonsChain();
	}


	/**
	 * CommonsのcomparatorChainを使用したサンプル
	 * <p>
	 * 通常のコンストラクタと値をセットするコンストラクタを設定することで
	 * 今までのロジックを壊さずにソート可能
	 * </p>
	 */

	@SuppressWarnings("unchecked")
	private void testCommonsChain() {

		ComparatorChain comparator = new ComparatorChain();

		List<TestDataBean> testDataBeanList = this.createTestDataBeanList();

		comparator.addComparator(new BeanComparator<TestDataBean>("kngk",new NullComparator()), true);
		comparator.addComparator(new BeanComparator<TestDataBean>("name",new NullComparator()));

		Collections.sort(testDataBeanList, comparator);

		this.printData(testDataBeanList);

	}

	/**
	 * テストデータ作成クラス
	 * @return
	 */
	private List<TestDataBean> createTestDataBeanList() {

		List<TestDataBean> testDataBeanList = new ArrayList<TestDataBean>();
		TestDataBean bean01 = new TestDataBean();
		TestDataBean bean02 = new TestDataBean();
		TestDataBean bean03 = new TestDataBean();
		TestDataBean bean04 = new TestDataBean();
		TestDataBean bean05 = new TestDataBean();
//
		bean01.setKngk("");
		bean02.setKngk(null);
		bean03.setKngk("1111");
		bean04.setKngk("1112");
		bean05.setKngk("1113");

		bean01.setName("name1");
		bean02.setName(null);
		bean03.setName(null);
		bean04.setName("");
		bean05.setName("name2");
//

//		testDataBeanList.add(new TestDataBean("","a"));
//		testDataBeanList.add(new TestDataBean("null","b"));
//		testDataBeanList.add(new TestDataBean("1111","c"));
//		testDataBeanList.add(new TestDataBean("2222","d"));
//		testDataBeanList.add(new TestDataBean("3333","e"));

		testDataBeanList.add(bean01);
		testDataBeanList.add(bean02);
		testDataBeanList.add(bean03);
		testDataBeanList.add(bean04);
		testDataBeanList.add(bean05);

		return testDataBeanList;
	}

	private void printData(List<TestDataBean> testDataBeanList) {


		for(TestDataBean bean : testDataBeanList) {

			System.out.print(bean.getKngk());
			System.out.print("\t");
			System.out.println(bean.getName());
//			System.out.print("\t");
//			System.out.print(bean.getShtnCd());
//			System.out.print("\t");
//			System.out.print(bean.getStartDate());
//			System.out.print("\t");
//			System.out.println(bean.getUserNo());


		}
	}
}
