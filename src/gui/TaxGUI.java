package gui;


import java.awt.event.*;

import javax.swing.*;


import business.CarManager;
import business.LandManager;
import xml.AddXMLFileUsingDOM;
import xml.ReadXMLFileUsingDOM;
import xml.RemXMLFileUsingDOM;

public class TaxGUI {
	JFrame f;

	void GUI() {

		f = new JFrame("Tax Calculator");// creating instance of JFrame

//begin-panel to add a taxpayer
		JButton b = new JButton("Add TaxPayer");// creating instance of JButton
		b.setBounds(10, 10, 150, 40);
		LandManager taxpayerLand = new LandManager();
		CarManager taxpayerCar = new CarManager();
		b.addActionListener(new ActionListener() {
			String Firstname;
			String Lastname;
			String LandSize;
			String CarCapacity;

			public void actionPerformed(ActionEvent e) {
				JFrame addf;
				addf = new JFrame();

				addf.setSize(400, 350);
				addf.setLayout(null);
				addf.setVisible(true);

				JLabel label1 = new JLabel("Enter Firstname");
				label1.setBounds(50, 25, 150, 20);
				JLabel label2 = new JLabel("Enter Lastname");
				label2.setBounds(50, 75, 150, 20);
				JLabel label3 = new JLabel("Enter Land Size");
				label3.setBounds(50, 125, 150, 20);
				JLabel label4 = new JLabel("Enter Car Capacity");
				label4.setBounds(50, 175, 150, 20);
				final JTextField firstname = new JTextField();
				firstname.setBounds(50, 50, 150, 20);

				firstname.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						Firstname = firstname.getText();
						int ok = 0;
						try {
							int Stringtoint = Integer.parseInt(Firstname);
						} catch (NumberFormatException exe) {

							if (Firstname.equals(""))
								JOptionPane.showMessageDialog(null, "Please Enter a string", "Invalid input",
										JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (ok == 1)
							firstname.setEditable(false);
						else {
							JOptionPane.showMessageDialog(null, "Please Enter a valid name", "Invalid input",
									JOptionPane.ERROR_MESSAGE);
							firstname.setText("");
							Firstname = firstname.getText();
						}

						// if(Firstname.equals(""))
						// JOptionPane.showMessageDialog(null, "Please Enter a valid name", "Invalid
						// input", JOptionPane.ERROR_MESSAGE);
						// else firstname.setEditable(false);
					}
				});

				final JTextField lastname = new JTextField();
				lastname.setBounds(50, 100, 150, 20);

				lastname.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						Lastname = lastname.getText();
						int ok = 0;
						try {
							int Stringtoint = Integer.parseInt(Lastname);
						} catch (NumberFormatException exe) {
							if (Lastname.equals(""))
								JOptionPane.showMessageDialog(null, "Please Enter a valid name", "Invalid input",
										JOptionPane.ERROR_MESSAGE);
							ok = 1;
							return;
						}
						if (ok == 1)
							lastname.setEditable(false);
						else {
							JOptionPane.showMessageDialog(null, "Please Enter a valid name", "Invalid input",
									JOptionPane.ERROR_MESSAGE);
							lastname.setText("");
							Lastname = lastname.getText();
						}
					}
				});

				final JTextField land = new JTextField();
				land.setBounds(50, 150, 150, 20);
				land.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						LandSize = land.getText();
						try {
							double Stringtoint = Double.parseDouble(LandSize);
						} catch (NumberFormatException exe) {

							if (land.equals(""))
								JOptionPane.showMessageDialog(null, "Empty string not allowed", "Number Error",
										JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error",
										JOptionPane.ERROR_MESSAGE);

							return;
						}

					}
				});

				final JTextField capacity = new JTextField();
				capacity.setBounds(50, 200, 150, 20);
				capacity.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						CarCapacity = capacity.getText();

						try {
							double Stringtoint = Double.parseDouble(CarCapacity);
						} catch (NumberFormatException exe) {

							if (capacity.equals(""))
								JOptionPane.showMessageDialog(null, "Empty string not allowed", "Number Error",
										JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error",
										JOptionPane.ERROR_MESSAGE);

							return;
						}
					}
				});

				JButton close = new JButton("Apply & Close");
				close.setBounds(125, 250, 130, 40);
				close.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(Firstname);
						System.out.println(Lastname);
						System.out.println(LandSize);
						System.out.println(CarCapacity);
						final AddXMLFileUsingDOM adder = new AddXMLFileUsingDOM(Firstname, Lastname, LandSize,
								CarCapacity);
						adder.add();
						addf.setVisible(false); // you can't see me!
						addf.dispose(); // Destroy the JFrame object
					}
				});
				addf.add(label1);
				addf.add(label2);
				addf.add(label3);
				addf.add(label4);
				addf.add(firstname);
				addf.add(lastname);
				addf.add(land);
				addf.add(capacity);
				addf.add(close);
			}
		});

//end-panel to add a taxpayer

//begin-button to remove a taxpayer

		JButton b1 = new JButton("Remove TaxPayer");// creating instance of JButton
		b1.setBounds(10, 60, 150, 40);

		JLabel label5 = new JLabel("Enter ID");
		label5.setBounds(170, 60, 150, 20);
		final JTextField rem = new JTextField();
		rem.setBounds(170, 80, 150, 20);
		f.add(label5);
		f.add(rem);
		label5.setVisible(false);
		rem.setVisible(false);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// System.out.println("rasengan");

				label5.setVisible(true);
				rem.setVisible(true);

				rem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = rem.getText();
						try {
							int Stringtoint = Integer.parseInt(id);
						} catch (NumberFormatException exe) {

							JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error",
									JOptionPane.ERROR_MESSAGE);

							return;
						}
						int idToString = Integer.parseInt(id);
						final RemXMLFileUsingDOM remover = new RemXMLFileUsingDOM(idToString);

						remover.remove();
						remover.changeID();
						SwingUtilities.updateComponentTreeUI(f);
						// label5.setVisible(false); //you can't see me!
						// rem.setVisible(false); //you can't see me!
						// need to add error if its too large
						rem.setText("");
					}
				});

			}
		});

//end-button to remove a taxpayer

//begin-display all taxpayers
		JButton b2 = new JButton("Display TaxPayers");// creating instance of JButton
		b2.setBounds(10, 110, 150, 40);

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame addf;
				addf = new JFrame("Display Taxpayers");

				addf.setSize(500, 700);
				addf.setLayout(null);
				addf.setVisible(true);

				int length = getLength();
				int n = length;
				int nr = length % 4;
				if (length < 4)
					display(addf, 0, length % 4);
				else
					display(addf, 0, 4);

			}
		});
//end-display all taxpayers

//begin-calculate tax for a taxpayer		
		JButton b3 = new JButton("Tax for one payer");// creating instance of JButton
		b3.setBounds(10, 160, 150, 40);
		// trebuie folosit si la all taxpayers
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame addf;
				addf = new JFrame("Calculate Tax for one Taxpayer");

				JButton b = new JButton("Compute Land Tax");// creating instance of JButton
				b.setBounds(10, 10, 150, 40);

				JLabel label = new JLabel("Enter ID");
				label.setBounds(170, 10, 150, 20);
				final JTextField rem = new JTextField();
				rem.setBounds(170, 30, 150, 20);
				JLabel label1 = new JLabel("");
				addf.add(label);
				addf.add(rem);
				addf.add(label1);
				label.setVisible(false);
				rem.setVisible(false);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// System.out.println("rasengan");

						label.setVisible(true);
						rem.setVisible(true);

						label1.setVisible(false);
						rem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String id = rem.getText();
								try {
									int Stringtoint = Integer.parseInt(id);
								} catch (NumberFormatException exe) {

									JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error",
											JOptionPane.ERROR_MESSAGE);

									return;
								}
								int idToString = Integer.parseInt(id);
								// System.out.print(taxpayer.taxForOnePayer(idToString));
								label1.setText("The Land tax for payer " + id + " is "
										+ taxpayerLand.taxForOnePayer(idToString - 1) + " lei");
								label1.setBounds(10, 60, 250, 20);

								label1.setVisible(true);

								SwingUtilities.updateComponentTreeUI(f);

								rem.setText("");
							}
						});

					}

				});
				// -------------------------

				JButton b1 = new JButton("Compute Car Tax");// creating instance of JButton
				b1.setBounds(10, 90, 150, 40);

				JLabel label2 = new JLabel("Enter ID");
				label2.setBounds(170, 90, 150, 20);
				final JTextField rem1 = new JTextField();
				rem1.setBounds(170, 110, 150, 20);
				JLabel label3 = new JLabel("");
				addf.add(label2);
				addf.add(rem1);
				addf.add(label3);
				label2.setVisible(false);
				rem1.setVisible(false);
				b1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// System.out.println("rasengan");

						label2.setVisible(true);
						rem1.setVisible(true);

						label3.setVisible(false);
						rem1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String id = rem1.getText();
								try {
									int Stringtoint = Integer.parseInt(id);
								} catch (NumberFormatException exe) {

									JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error",
											JOptionPane.ERROR_MESSAGE);

									return;
								}
								int idToString = Integer.parseInt(id);
								// System.out.print(taxpayer.taxForOnePayer(idToString));
								label3.setText("The Car tax for payer " + id + " is "
										+ taxpayerCar.taxForOnePayer(idToString - 1) + " lei");
								label3.setBounds(10, 140, 250, 20);

								label3.setVisible(true);

								SwingUtilities.updateComponentTreeUI(f);

								rem1.setText("");
							}
						});

					}

				});

				// --------------------------

				JButton b2 = new JButton("Compute Both Tax");// creating instance of JButton
				b2.setBounds(10, 170, 150, 40);

				JLabel label4 = new JLabel("Enter ID");
				label4.setBounds(170, 170, 150, 20);
				final JTextField rem2 = new JTextField();
				rem2.setBounds(170, 190, 150, 20);
				JLabel label5 = new JLabel("");
				addf.add(label4);
				addf.add(rem2);
				addf.add(label5);
				label4.setVisible(false);
				rem2.setVisible(false);
				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// System.out.println("rasengan");

						label4.setVisible(true);
						rem2.setVisible(true);

						label5.setVisible(false);
						rem2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String id = rem2.getText();
								try {
									int Stringtoint = Integer.parseInt(id);
								} catch (NumberFormatException exe) {

									JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error",
											JOptionPane.ERROR_MESSAGE);

									return;
								}
								int idToString = Integer.parseInt(id);
								// System.out.print(taxpayer.taxForOnePayer(idToString));
								double total = taxpayerCar.taxForOnePayer(idToString - 1)
										+ taxpayerLand.taxForOnePayer(idToString - 1);
								label5.setText("The Total tax for payer " + id + " is " + total + " lei");
								label5.setBounds(10, 220, 250, 20);

								label5.setVisible(true);

								SwingUtilities.updateComponentTreeUI(f);

								rem2.setText("");
							}
						});

					}

				});

				addf.add(b);
				addf.add(b1);
				addf.add(b2);
				addf.setSize(500, 300);
				addf.setLayout(null);
				addf.setVisible(true);
				// taxpayerLand.setTax(3);
				// System.out.print(taxpayerLand.taxForOnePayer(1));
			}
		});

//end-calculate tax for a taxpayer		

//begin-Calculate tax for all taxpayers

		JButton b4 = new JButton("Tax for all payers");// creating instance of JButton
		b4.setBounds(10, 210, 150, 40);

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame addf;
				addf = new JFrame("Calculate Tax for all Taxpayers");

				JButton b = new JButton("Compute Land Tax");// creating instance of JButton
				b.setBounds(10, 10, 150, 40);

				JLabel label = new JLabel("");
				label.setVisible(false);
				label.setBounds(10, 50, 350, 40);
				addf.add(label);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						label.setText(
								"The total land tax for all taxpayers is:" + taxpayerLand.taxForAllPayers() + " lei");
						label.setVisible(true);

					}
				});

				JButton b1 = new JButton("Compute Car Tax");// creating instance of JButton
				b1.setBounds(10, 90, 150, 40);

				JLabel label1 = new JLabel("");
				label1.setVisible(false);
				label1.setBounds(10, 130, 350, 40);
				addf.add(label1);
				b1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						label1.setText(
								"The total car tax for all taxpayers is:" + taxpayerCar.taxForAllPayers() + " lei");
						label1.setVisible(true);

					}
				});

				JButton b3 = new JButton("Compute Total Tax");// creating instance of JButton
				b3.setBounds(10, 170, 150, 40);

				JLabel label2 = new JLabel("");
				label2.setVisible(false);
				label2.setBounds(10, 210, 350, 40);
				addf.add(label2);
				b3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						double d = taxpayerCar.taxForAllPayers() + taxpayerLand.taxForAllPayers();
						label2.setText("The total tax for all taxpayers is:" + d + " lei");
						label2.setVisible(true);

					}
				});
				addf.add(b);
				addf.add(b1);
				addf.add(b3);
				addf.setSize(500, 300);
				addf.setLayout(null);
				addf.setVisible(true);

			}
		});

////end-Calculate tax for all taxpayers

//begin-set tax land button

		JButton b5 = new JButton("Set tax land");// creating instance of JButton
		b5.setBounds(10, 260, 150, 40);

		JLabel label7 = new JLabel("Enter ID");
		label7.setBounds(170, 260, 150, 20);
		JLabel label9 = new JLabel("%");
		label9.setBounds(325, 280, 150, 20);
		final JTextField setL = new JTextField();
		setL.setBounds(170, 280, 150, 20);
		f.add(label7);
		f.add(label9);
		f.add(setL);
		label7.setVisible(false);
		label9.setVisible(false);
		setL.setVisible(false);

		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				label7.setVisible(true);
				label9.setVisible(true);
				setL.setVisible(true);

				setL.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = setL.getText();
						try {
							int Stringtoint = Integer.parseInt(id);
						} catch (NumberFormatException exe) {

							JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error",
									JOptionPane.ERROR_MESSAGE);

							return;
						}
						double idToString = Double.parseDouble(id);
						double d1 = idToString / 100;
						taxpayerLand.setTax(d1);
						SwingUtilities.updateComponentTreeUI(f);

						setL.setText("");
					}
				});

			}
		});

////end-set tax button		

//begin-set tax car button

		JButton b6 = new JButton("Set tax car");// creating instance of JButton
		b6.setBounds(10, 310, 150, 40);

		JLabel label8 = new JLabel("Enter ID");
		label8.setBounds(170, 310, 150, 20);
		JLabel label10 = new JLabel("%");
		label10.setBounds(325, 330, 150, 20);
		final JTextField setC = new JTextField();
		setC.setBounds(170, 330, 150, 20);
		f.add(label8);
		f.add(label10);
		f.add(setC);
		label8.setVisible(false);
		label10.setVisible(false);
		setC.setVisible(false);

		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				label8.setVisible(true);
				label10.setVisible(true);
				setC.setVisible(true);

				setC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = setC.getText();
						try {
							int Stringtoint = Integer.parseInt(id);
						} catch (NumberFormatException exe) {

							JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error",
									JOptionPane.ERROR_MESSAGE);

							return;
						}
						double idToString = Double.parseDouble(id);
						double d1 = idToString / 100;
						// System.out.print(d1);
						taxpayerCar.setTax(d1);
						SwingUtilities.updateComponentTreeUI(f);

						setC.setText("");
					}
				});

			}
		});

		//// end-set tax car button

		f.add(b);
		f.add(b1);
		f.add(b2); // adding button in JFrame
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.setSize(400, 400);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible

	}

	void add(JFrame jf, int position, String Id, String firstname, String lastname, String land, String car) {

		JLabel label0 = new JLabel("ID:");
		label0.setBounds(10, 0 + position, 150, 20);
		jf.add(label0);

		JLabel label5 = new JLabel(Id);
		label5.setBounds(250, 0 + position, 150, 20);
		jf.add(label5);

		JLabel label1 = new JLabel("Firstname:");
		label1.setBounds(10, 25 + position, 150, 20);
		jf.add(label1);

		JLabel label6 = new JLabel(firstname);
		label6.setBounds(250, 25 + position, 150, 20);
		jf.add(label6);

		JLabel label2 = new JLabel("Lastname:");
		label2.setBounds(10, 50 + position, 150, 20);
		jf.add(label2);

		JLabel label7 = new JLabel(lastname);
		label7.setBounds(250, 50 + position, 150, 20);
		jf.add(label7);

		JLabel label3 = new JLabel("Land Size:");
		label3.setBounds(10, 75 + position, 150, 20);
		jf.add(label3);

		JLabel label8 = new JLabel(land +" m\u00B2");
		label8.setBounds(250, 75 + position, 150, 20);
		jf.add(label8);

		JLabel label4 = new JLabel("Car Capacity:");
		label4.setBounds(10, 100 + position, 150, 20);
		jf.add(label4);

		JLabel label9 = new JLabel(car+" CC");
		label9.setBounds(250, 100 + position, 150, 20);
		jf.add(label9);

	}

	void display(JFrame addf, int begin, int end) {
		final ReadXMLFileUsingDOM displayer = new ReadXMLFileUsingDOM();
		displayer.display();
		int position = 0;

		JLabel label5 = new JLabel("Enter page number:");
		label5.setBounds(200, 600, 150, 20);

		final JTextField rem = new JTextField();
		rem.setBounds(230, 625, 40, 20);

		int length = getLength();
		int nr = length % 4;
		if (nr == 0) {
			length = length / 4;

		} else
			length = length / 4 + 1;
		JLabel label1 = new JLabel("This is page:" + "1/" + length);
		label1.setBounds(100, 600, 150, 20);
		if (begin == 0)
			addf.add(label1);

		for (int i = begin; i < begin + end; i++) {
			String s = String.valueOf(i + 1);
			add(addf, position, s, displayer.getFirstnames().get(i), displayer.getLastnames().get(i),
					displayer.getLands().get(i), displayer.getCars().get(i));
			// double d1=Double.parseDouble(displayer.getLands().get(i));
			position = position + 150;

		}

		rem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = rem.getText();
				try {
					int Stringtoint = Integer.parseInt(id);
				} catch (NumberFormatException exe) {

					JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error",
							JOptionPane.ERROR_MESSAGE);

					return;
				}
				int idToString = Integer.parseInt(id);

				addf.getContentPane().removeAll();
				addf.getContentPane().revalidate();
				addf.getContentPane().repaint();
				int length = getLength();
				int n = length;
				int nr = length % 4;
				if (nr == 0) {
					length = length / 4;

				} else
					length = length / 4 + 1;
				if ((idToString - 1) * 4 + 4 > n)
					display(addf, (idToString - 1) * 4, nr);
				else
					display(addf, (idToString - 1) * 4, 4);
				JLabel label1 = new JLabel("This is page:" + idToString + "/" + length);
				label1.setBounds(100, 600, 150, 20);
				if ((idToString - 1) != 0)
					addf.add(label1);

				rem.setText("");
			}
		});

		addf.add(rem);
		addf.add(label5);

		position = 0;
	}

	int getLength() {

		final ReadXMLFileUsingDOM displayer = new ReadXMLFileUsingDOM();
		displayer.display();
		int length = displayer.getNames().size();
		return length;

	}

}
