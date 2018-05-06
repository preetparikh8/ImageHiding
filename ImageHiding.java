package Crypto;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import java.io.*;

import javax.imageio.ImageIO;

import javax.swing.*;

public class ImageHiding extends JFrame implements ActionListener {
	BufferedImage hostImage;
	BufferedImage secretImage;

	JPanel controlPanel;
	JPanel imagePanel;

	JTextField encodeBitsText;
	JTextField encodeBitsText1;
	JTextField encodeBitsText2;
	JTextField encodeBitsText3;
	JButton encodeBitsPlus;
	JButton encodeBitsMinus;
	JButton encodeBitsPlus1;
	JButton encodeBitsMinus1;
	JButton encodeBitsPlus2;
	JButton encodeBitsMinus2;
	JButton encodeBitsPlus3;
	JButton encodeBitsMinus3;
	JButton Type;
	JButton Type1;
	JButton Type2;
	JButton Type3;

	JTextField nBitsText;
	JButton nBitsPlus;
	JButton nBitsMinus;

	ImageCanvas hostCanvas;
	ImageCanvas secretCanvas;

	Steganography s;

	public BufferedImage getHostImage() {
		BufferedImage img = null;

		try {
			img = ImageIO
					.read(new File("host_image.jpg"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return img;
	}

	public BufferedImage getSecretImage() {
		BufferedImage img = null;

		try {
			img = ImageIO
					.read(new File("secret_image.jpg"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return img;
	}

	public int getBits() {
		return Integer.parseInt(encodeBitsText.getText());
	}

	public int getBits1() {
		return Integer.parseInt(encodeBitsText1.getText());
	}
	
	public int getBits2() {
		return Integer.parseInt(encodeBitsText2.getText());
	}
	
	public int getBits3() {
		return Integer.parseInt(encodeBitsText3.getText());
	}
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == encodeBitsPlus) {
			int bits = this.getBits() + 1;

			if (bits > 8) {
				bits = 8;
			}

			encodeBitsText.setText(Integer.toString(bits));

			s = new Steganography(this.getHostImage());
			s.encode(this.getSecretImage(), bits);

			hostCanvas.setImage(s.getImage());
			hostCanvas.repaint();

			s = new Steganography(this.getSecretImage());
			s.getMaskedImage(bits);

			secretCanvas.setImage(s.getImage());
			secretCanvas.repaint();
		} 
		
		else if (source == encodeBitsMinus) {
			int bits = this.getBits() - 1;

			if (bits < 0) {
				bits = 0;
			}

			encodeBitsText.setText(Integer.toString(bits));

			s = new Steganography(this.getHostImage());
			s.encode(this.getSecretImage(), bits);

			hostCanvas.setImage(s.getImage());
			hostCanvas.repaint();

			s = new Steganography(this.getSecretImage());
			s.getMaskedImage(bits);

			secretCanvas.setImage(s.getImage());
			secretCanvas.repaint();
		}
		
		else if (source == encodeBitsPlus1) {
			int bits = this.getBits1() + 1;

			if (bits > 8) {
				bits = 8;
			}

			encodeBitsText1.setText(Integer.toString(bits));

			s = new Steganography(this.getHostImage());
			s.encode1(this.getSecretImage(), bits);

			hostCanvas.setImage(s.getImage());
			hostCanvas.repaint();

			s = new Steganography(this.getSecretImage());
			s.getMaskedImage(bits);

			secretCanvas.setImage(s.getImage());
			secretCanvas.repaint();
		}
		
		 else if (source == encodeBitsMinus1) {
				int bits = this.getBits1() - 1;

				if (bits < 0) {
					bits = 0;
				}

				encodeBitsText1.setText(Integer.toString(bits));

				s = new Steganography(this.getHostImage());
				s.encode1(this.getSecretImage(), bits);

				hostCanvas.setImage(s.getImage());
				hostCanvas.repaint();

				s = new Steganography(this.getSecretImage());
				s.getMaskedImage(bits);

				secretCanvas.setImage(s.getImage());
				secretCanvas.repaint();
			}
		
		 else if (source == encodeBitsPlus2) {
				int bits = this.getBits2() + 1;

				if (bits > 8) {
					bits = 8;
				}

				encodeBitsText2.setText(Integer.toString(bits));

				s = new Steganography(this.getHostImage());
				s.encode2(this.getSecretImage(), bits);

				hostCanvas.setImage(s.getImage());
				hostCanvas.repaint();

				s = new Steganography(this.getSecretImage());
				s.getMaskedImage(bits);

				secretCanvas.setImage(s.getImage());
				secretCanvas.repaint();
			}
			
			 else if (source == encodeBitsMinus2) {
					int bits = this.getBits2() - 1;

					if (bits < 0) {
						bits = 0;
					}

					encodeBitsText2.setText(Integer.toString(bits));

					s = new Steganography(this.getHostImage());
					s.encode2(this.getSecretImage(), bits);

					hostCanvas.setImage(s.getImage());
					hostCanvas.repaint();

					s = new Steganography(this.getSecretImage());
					s.getMaskedImage(bits);

					secretCanvas.setImage(s.getImage());
					secretCanvas.repaint();
				}
		
			 else if (source == encodeBitsPlus3) {
					int bits = this.getBits3() + 1;

					if (bits > 8) {
						bits = 8;
					}

					encodeBitsText3.setText(Integer.toString(bits));

					s = new Steganography(this.getHostImage());
					s.encode3(this.getSecretImage(), bits);

					hostCanvas.setImage(s.getImage());
					hostCanvas.repaint();

					s = new Steganography(this.getSecretImage());
					s.getMaskedImage(bits);

					secretCanvas.setImage(s.getImage());
					secretCanvas.repaint();
				}
				
				 else if (source == encodeBitsMinus3) {
						int bits = this.getBits3() - 1;

						if (bits < 0) {
							bits = 0;
						}

						encodeBitsText3.setText(Integer.toString(bits));

						s = new Steganography(this.getHostImage());
						s.encode3(this.getSecretImage(), bits);

						hostCanvas.setImage(s.getImage());
						hostCanvas.repaint();

						s = new Steganography(this.getSecretImage());
						s.getMaskedImage(bits);

						secretCanvas.setImage(s.getImage());
						secretCanvas.repaint();
					}
	}

	public ImageHiding() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setTitle("Image Hiding Demo");

		Container container = this.getContentPane();

		this.setLayout(layout);
		Type = new JButton("Hide MSB of Secret Image in LSB of Host Image");
		Type.setBounds(500, 500, 100, 100);
		Type.addActionListener(this);

		gbc.weightx = 1.0;
		layout.setConstraints(Type, gbc);
		this.add(Type);
		
		this.setLayout(layout);
		this.add(new JLabel("Bits to encode into host image:"));

		encodeBitsText = new JTextField("0", 5);
		encodeBitsText.setEditable(false);

		gbc.weightx = -1.0;
		layout.setConstraints(encodeBitsText, gbc);
		this.add(encodeBitsText);

		encodeBitsPlus = new JButton("+");
		encodeBitsPlus.addActionListener(this);

		encodeBitsMinus = new JButton("-");
		encodeBitsMinus.addActionListener(this);

		gbc.weightx = 1.0;
		layout.setConstraints(encodeBitsPlus, gbc);
		this.add(encodeBitsPlus);
		// this.add(controlPanel);
		// controlPanel.add(encodeBitsPlus);
		// encodeBitsPlus.setBounds(100,100,100,100);

		gbc.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(encodeBitsMinus, gbc);
		this.add(encodeBitsMinus);

		Type1 = new JButton("Hide MSB of Secret Image in MSB of Host Image");
		Type1.setBounds(500, 500, 100, 100);
		Type1.addActionListener(this);

		gbc.weightx = 1.0;
		layout.setConstraints(Type1, gbc);
		this.add(Type1);

		this.add(new JLabel("Bits to encode into host image:"));

		encodeBitsText1 = new JTextField("0", 5);
		encodeBitsText1.setEditable(false);

		gbc.weightx = -1.0;
		layout.setConstraints(encodeBitsText1, gbc);
		this.add(encodeBitsText1);

		encodeBitsPlus1 = new JButton("+");
		encodeBitsPlus1.addActionListener(this);

		encodeBitsMinus1 = new JButton("-");
		encodeBitsMinus1.addActionListener(this);

		gbc.weightx = 1.0;
		layout.setConstraints(encodeBitsPlus1, gbc);
		this.add(encodeBitsPlus1);
		// this.add(controlPanel);
		// controlPanel.add(encodeBitsPlus);
		// encodeBitsPlus.setBounds(100,100,100,100);

		gbc.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(encodeBitsMinus1, gbc);
		this.add(encodeBitsMinus1);
		
		
		Type2 = new JButton("Hide LSB of Secret Image in LSB of Host Image");
		Type2.setBounds(500, 500, 100, 100);
		Type2.addActionListener(this);

		gbc.weightx = 1.0;
		layout.setConstraints(Type2, gbc);
		this.add(Type2);

		this.add(new JLabel("Bits to encode into host image:"));

		encodeBitsText2 = new JTextField("0", 5);
		encodeBitsText2.setEditable(false);

		gbc.weightx = -1.0;
		layout.setConstraints(encodeBitsText2, gbc);
		this.add(encodeBitsText2);

		encodeBitsPlus2 = new JButton("+");
		encodeBitsPlus2.addActionListener(this);

		encodeBitsMinus2 = new JButton("-");
		encodeBitsMinus2.addActionListener(this);

		gbc.weightx = 1.0;
		layout.setConstraints(encodeBitsPlus2, gbc);
		this.add(encodeBitsPlus2);
		// this.add(controlPanel);
		// controlPanel.add(encodeBitsPlus);
		// encodeBitsPlus.setBounds(100,100,100,100);

		gbc.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(encodeBitsMinus2, gbc);
		this.add(encodeBitsMinus2);
		
		Type3 = new JButton("Hide LSB of Secret Image in MSB of Host Image");
		Type3.setBounds(500, 500, 100, 100);
		Type3.addActionListener(this);

		gbc.weightx = 1.0;
		layout.setConstraints(Type3, gbc);
		this.add(Type3);

		this.add(new JLabel("Bits to encode into host image:"));

		encodeBitsText3 = new JTextField("0", 5);
		encodeBitsText3.setEditable(false);

		gbc.weightx = -1.0;
		layout.setConstraints(encodeBitsText3, gbc);
		this.add(encodeBitsText3);

		encodeBitsPlus3 = new JButton("+");
		encodeBitsPlus3.addActionListener(this);

		encodeBitsMinus3 = new JButton("-");
		encodeBitsMinus3.addActionListener(this);

		gbc.weightx = 1.0;
		layout.setConstraints(encodeBitsPlus3, gbc);
		this.add(encodeBitsPlus3);
		// this.add(controlPanel);
		// controlPanel.add(encodeBitsPlus);
		// encodeBitsPlus.setBounds(100,100,100,100);

		gbc.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(encodeBitsMinus3, gbc);
		this.add(encodeBitsMinus3);
		
		GridBagLayout imageGridbag = new GridBagLayout();
		GridBagConstraints imageGBC = new GridBagConstraints();

		imagePanel = new JPanel();
		imagePanel.setLayout(imageGridbag);

		JLabel hostImageLabel = new JLabel("Host image:");
		JLabel secretImageLabel = new JLabel("Secret image:");

		imagePanel.add(hostImageLabel);

		imageGBC.gridwidth = GridBagConstraints.REMAINDER;
		imageGridbag.setConstraints(secretImageLabel, imageGBC);
		imagePanel.add(secretImageLabel);

		hostCanvas = new ImageCanvas(this.getHostImage());
		secretCanvas = new ImageCanvas(this.getSecretImage());

		imagePanel.add(hostCanvas);
		imagePanel.add(secretCanvas);

		gbc.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(imagePanel, gbc);
		this.add(imagePanel);

		Steganography host = new Steganography(this.getHostImage());
		host.encode(this.getSecretImage(), this.getBits());
		hostCanvas.setImage(host.getImage());

		Steganography secret = new Steganography(this.getSecretImage());
		secret.getMaskedImage(this.getBits());
		secretCanvas.setImage(secret.getImage());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();

		this.setVisible(true);
	}

	public static void main(String[] args) {
		ImageHiding frame = new ImageHiding();
		frame.setVisible(true);
	}

	public class ImageCanvas extends JPanel {
		Image img;

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, this);
		}

		public void setImage(Image img) {
			this.img = img;
		}

		public ImageCanvas(Image img) {
			this.img = img;

			this.setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
		}
	}
}

class Steganography {
	BufferedImage image;

	public void getMaskedImage(int bits) {
		int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

		int maskBits = (int) (Math.pow(2, bits)) - 1 << (8 - bits);
		int mask = (maskBits << 24) | (maskBits << 16) | (maskBits << 8) | maskBits;

		for (int i = 0; i < imageRGB.length; i++) {
			imageRGB[i] = imageRGB[i] & mask;
		}

		image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
	}

	public void encode(BufferedImage encodeImage, int encodeBits) {
		int[] encodeRGB = encodeImage.getRGB(0, 0, encodeImage.getWidth(null), encodeImage.getHeight(null), null, 0,
				encodeImage.getWidth(null));
		int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

		int encodeByteMask = (int) (Math.pow(2, encodeBits)) - 1 << (8 - encodeBits);
		int encodeMask = (encodeByteMask << 24) | (encodeByteMask << 16) | (encodeByteMask << 8) | encodeByteMask;

		int decodeByteMask = ~(encodeByteMask >>> (8 - encodeBits)) & 0xFF;
		int hostMask = (decodeByteMask << 24) | (decodeByteMask << 16) | (decodeByteMask << 8) | decodeByteMask;

		for (int i = 0; i < imageRGB.length; i++) {
			int encodeData = (encodeRGB[i] & encodeMask) >>> (8 - encodeBits);
			imageRGB[i] = (imageRGB[i] & hostMask) | (encodeData & ~hostMask);
		}
		
		image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
	}
	
	public void encode1(BufferedImage encodeImage, int encodeBits) {
		int[] encodeRGB = encodeImage.getRGB(0, 0, encodeImage.getWidth(null), encodeImage.getHeight(null), null, 0,
				encodeImage.getWidth(null));
		int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

		int encodeByteMask = (int) (Math.pow(2, encodeBits)) - 1 << (8 - encodeBits);
		int encodeMask = (encodeByteMask << 24) | (encodeByteMask << 16) | (encodeByteMask << 8) | encodeByteMask;

		int decodeByteMask = ~(encodeByteMask << (encodeBits)) & 0x00;
		int hostMask = (decodeByteMask >> 24) | (decodeByteMask >> 16) | (decodeByteMask >> 8) | decodeByteMask;

		for (int i = 0; i < imageRGB.length; i++) {
			int encodeData = (encodeRGB[i] & encodeMask) >>> (8 - encodeBits);
			imageRGB[i] = (imageRGB[i] & hostMask) | (encodeData & ~hostMask);
		}
		
		image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
	}
	
	public void encode2(BufferedImage encodeImage, int encodeBits) {
		int[] encodeRGB = encodeImage.getRGB(0, 0, encodeImage.getWidth(null), encodeImage.getHeight(null), null, 0,
				encodeImage.getWidth(null));
		int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

		int encodeByteMask = (int) (Math.pow(2, encodeBits)) - 1 >> (8 - encodeBits);
		int encodeMask = (encodeByteMask >> 24) | (encodeByteMask >> 16) | (encodeByteMask >> 8) | encodeByteMask;

		int decodeByteMask = ~(encodeByteMask >>> (8 - encodeBits)) & 0xFF;
		int hostMask = (decodeByteMask << 24) | (decodeByteMask << 16) | (decodeByteMask << 8) | decodeByteMask;

		for (int i = 0; i < imageRGB.length; i++) {
			int encodeData = (encodeRGB[i] & encodeMask) >>> (8 - encodeBits);
			imageRGB[i] = (imageRGB[i] & hostMask) | (encodeData & ~hostMask);
		}
		
		image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
	}
	
	public void encode3(BufferedImage encodeImage, int encodeBits) {
		int[] encodeRGB = encodeImage.getRGB(0, 0, encodeImage.getWidth(null), encodeImage.getHeight(null), null, 0,
				encodeImage.getWidth(null));
		int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

		int encodeByteMask = (int) (Math.pow(2, encodeBits)) - 1 >> (8 - encodeBits);
		int encodeMask = (encodeByteMask >> 24) | (encodeByteMask >> 16) | (encodeByteMask >> 8) | encodeByteMask;

		int decodeByteMask = ~(encodeByteMask << (encodeBits)) & 0x00;
		int hostMask = (decodeByteMask >> 24) | (decodeByteMask >> 16) | (decodeByteMask >> 8) | decodeByteMask;
		
		for (int i = 0; i < imageRGB.length; i++) {
			int encodeData = (encodeRGB[i] & encodeMask) >>> (8 - encodeBits);
			imageRGB[i] = (imageRGB[i] & hostMask) | (encodeData & ~hostMask);
		}
		
		image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
	}

	public Image getImage() {
		return image;
	}

	public Steganography(BufferedImage image) {
		this.image = image;
	}
}