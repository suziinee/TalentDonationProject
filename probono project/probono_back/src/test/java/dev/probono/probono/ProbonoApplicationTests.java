// package dev.probono.probono;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.Test;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.boot.test.context.SpringBootTest;

// <<<<<<< .merge_file_a11968
// <<<<<<< HEAD
// import dev.probono.probono.model.entity.Match;
// import dev.probono.probono.model.entity.Person;
// import dev.probono.probono.model.entity.Talent;
// =======
// import dev.probono.probono.model.Matching;
// import dev.probono.probono.model.Person;
// import dev.probono.probono.model.Talent;
// >>>>>>> b8b612827103d8c4787874b03cd8d60e2570dff1
// import dev.probono.probono.repository.MatchRepository;
// import dev.probono.probono.repository.PersonRepository;
// import dev.probono.probono.repository.TalentRepository;

// =======
// // import dev.probono.probono.model.entity.Match;
// // import dev.probono.probono.model.entity.Person;
// // import dev.probono.probono.model.entity.Talent;
// // import dev.probono.probono.repository.MatchRepository;
// // import dev.probono.probono.repository.PersonRepository;
// // import dev.probono.probono.repository.TalentRepository;

// // import java.util.ArrayList;
// // import java.util.List;

// >>>>>>> .merge_file_a21916

// // @SpringBootTest
// class ProbonoApplicationTests {

//    @Test
//    void contextLoads() {
//    }

// <<<<<<< .merge_file_a11968
// <<<<<<< HEAD
//    @Autowired
//    PersonRepository pr;
// =======
//    // @Autowired
//    // PersonRepository pr;
// >>>>>>> .merge_file_a21916
   
//    // @Autowired
//    // TalentRepository tr;

// <<<<<<< .merge_file_a11968
//    @Autowired
//    MatchRepository mr;
// =======
// 	@Autowired
// 	PersonRepository pr;
	
// 	@Autowired
// 	TalentRepository tr;

// 	@Autowired
// 	MatchRepository mr;


// 	@Test
// 	public void saveTalent() {

// 		Talent t1 = new Talent("talent_1");
// 		tr.save(t1);

// 		Talent t2 = new Talent("talent_2");
// 		tr.save(t2);

// 		Talent t3 = new Talent("talent_3");
// 		tr.save(t3);

// 	}

// 	@Test
// 	public void savePerson() {
// >>>>>>> b8b612827103d8c4787874b03cd8d60e2570dff1
// =======
//    // @Autowired
//    // MatchRepository mr;
// >>>>>>> .merge_file_a21916

//    // @Test
//    // public void saveTalent() {

// 	//   Talent t1 = new Talent("talent_1");
// 	//   tr.save(t1);

// 	//   Talent t2 = new Talent("talent_2");
// 	//   tr.save(t2);

// 	//   Talent t3 = new Talent("talent_3");
// 	//   tr.save(t3);

//    // }

//    // @Test
//    // public void savePerson() {

//    //    List<Long> list = new ArrayList<>();
//    //    List<Long> list1 = new ArrayList<>();

//    //    list.add(1L);
//    //    list.add(2L);
//    //    list.add(3L);

//    //    list1.add(4L);
//    //    list1.add(5L);
      
//    //    Person p1 = new Person("Lim", "emal@aaa", list, list1);
//    //    Person p2 = new Person("Kim", "email@bbb", null, list1);
//    //    Person p3 = new Person("Jang", "email@ccc", list, null);
//    //    Person p4 = new Person("Lee", "email@ddd", null, list1);
//    //    Person p5 = new Person("Oh", "email@eee", list, null);

//    //    pr.save(p1);
//    //    pr.save(p2);
//    //    pr.save(p3);
//    //    pr.save(p4);
//    //    pr.save(p5);
      
//    //  }

// <<<<<<< .merge_file_a11968
// 	@Test
// 	public void saveMatch() {
// <<<<<<< HEAD
// 		Match m1 = new Match(1L, 2L, 1L);
// 		Match m2 = new Match(2L, 3L, 2L);
// 		Match m3 = new Match(4L, 5L, 3L);
// =======
// 	// @Test
// 	// public void saveMatch() {
// 	// 	Match m1 = new Match(1L, 2L, 1L);
// 	// 	Match m2 = new Match(2L, 3L, 2L);
// 	// 	Match m3 = new Match(4L, 5L, 3L);
// >>>>>>> .merge_file_a21916

//    //    mr.save(m1);
// 	// 	mr.save(m2);
// 	// 	mr.save(m3);
// 	// }

// <<<<<<< .merge_file_a11968
//    @Test
//    public void getAllTalents() {
// =======
// 		Matching m1 = new Matching(1L, 2L, 1L);
// 		mr.save(m1);
// 		Matching m2 = new Matching(2L, 3L, 2L);
// 		mr.save(m2);
// 		Matching m3 = new Matching(4L, 5L, 3L);
// 		mr.save(m3);
// 	}


// 	@Test
// 	public void getAllTalents() {
// >>>>>>> b8b612827103d8c4787874b03cd8d60e2570dff1
// =======
//    // @Test
//    // public void getAllTalents() {
// >>>>>>> .merge_file_a21916

//    //    List<Talent> list = tr.findAll();
      
// <<<<<<< .merge_file_a11968
//       for(Talent t : list) {
//          System.out.println(t.getId() + " " + t.getTalentType());
//       }
//    }

// <<<<<<< HEAD
//    @Test
//    public void getAllBeneficiaries() {
//       List<Person> list = pr.findByListBenefitNotNull();
// =======
// 	@Test
// 	public void getAllBeneficiaries() {
// 		List<Person> list = pr.findByListBenefitNotNull();
// >>>>>>> b8b612827103d8c4787874b03cd8d60e2570dff1

//       for(Person p : list) {
//          System.out.println(p.getId() + ", " + p.getName() + ", " + p.getListBenefit());
//       }
//    }

// <<<<<<< HEAD
//    @Test
// =======
// 	@Test
// >>>>>>> b8b612827103d8c4787874b03cd8d60e2570dff1
//     public void getAllDonators() {
//         List<Person> list = pr.findByListDonationNotNull();
//         for(Person p : list) {
//             System.out.println(p.getId() + ", " + p.getName() + ", " + p.getListDonation().get(0));
//         }
//     }
// <<<<<<< HEAD
// =======
//    //    for(Talent t : list) {
//    //       System.out.println(t.getId() + " " + t.getTalentType());
//    //    }
//    // }

//    // @Test
//    // public void getAllBeneficiaries() {
//    //    List<Person> list = pr.findByListBenefitNotNull();

//    //    for(Person p : list) {
//    //       System.out.println(p.getId() + ", " + p.getName() + ", " + p.getListBenefit());
//    //    }
//    // }

//    // @Test
//    //  public void getAllDonators() {
//    //      List<Person> list = pr.findByListDonationNotNull();
//    //      for(Person p : list) {
//    //          System.out.println(p.getId() + ", " + p.getName() + ", " + p.getListDonation().get(0));
//    //      }
//    //  }
// >>>>>>> .merge_file_a21916


// =======
// >>>>>>> b8b612827103d8c4787874b03cd8d60e2570dff1

// }
