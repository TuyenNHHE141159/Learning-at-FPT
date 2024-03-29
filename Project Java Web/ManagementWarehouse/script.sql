USE [FlowerTayTuu]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](50) NULL,
	[pass] [nchar](10) NULL,
	[accid] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[accid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Account1]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account1](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[date] [date] NULL,
	[paymentmethod] [nvarchar](50) NULL,
	[customerID] [int] NOT NULL,
	[status] [int] NULL,
	[paidMoney] [float] NULL,
	[paidDate] [date] NULL,
 CONSTRAINT [PK_Bill_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BillLine]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillLine](
	[billID] [int] NOT NULL,
	[flowerID] [int] NOT NULL,
	[quantity] [int] NULL,
	[price] [float] NULL,
 CONSTRAINT [PK_BillLine_1] PRIMARY KEY CLUSTERED 
(
	[billID] ASC,
	[flowerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[phone] [varchar](50) NULL,
	[address] [nvarchar](50) NULL,
	[isfarmer] [int] NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[department]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[department](
	[id] [int] NULL,
	[name] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feature]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feature](
	[fid] [int] NOT NULL,
	[url] [nvarchar](max) NULL,
 CONSTRAINT [PK_Feature] PRIMARY KEY CLUSTERED 
(
	[fid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FeatureGroup]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeatureGroup](
	[fid] [int] NOT NULL,
	[gid] [int] NOT NULL,
 CONSTRAINT [PK_FeatureGroup] PRIMARY KEY CLUSTERED 
(
	[fid] ASC,
	[gid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Flower]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Flower](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NULL,
	[image] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK_Flower_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Group]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Group](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
 CONSTRAINT [PK_Group] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GroupAccount]    Script Date: 21/04/2021 22:37:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GroupAccount](
	[gid] [int] NOT NULL,
	[username] [nvarchar](50) NULL,
	[accid] [int] NOT NULL,
 CONSTRAINT [PK_GroupAccount] PRIMARY KEY CLUSTERED 
(
	[gid] ASC,
	[accid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([username], [pass], [accid]) VALUES (N'tuyen', N'123       ', 1)
INSERT [dbo].[Account] ([username], [pass], [accid]) VALUES (N'viet', N'456       ', 2)
INSERT [dbo].[Account] ([username], [pass], [accid]) VALUES (N'son', N'123       ', 3)
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
SET IDENTITY_INSERT [dbo].[Account1] ON 

INSERT [dbo].[Account1] ([id], [username], [password]) VALUES (1, N'tuyen', N'123')
SET IDENTITY_INSERT [dbo].[Account1] OFF
GO
SET IDENTITY_INSERT [dbo].[Bill] ON 

INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (1, CAST(N'2021-01-01' AS Date), N'cash', 1, 1, 5488356, CAST(N'2021-03-20' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (2, CAST(N'2021-02-02' AS Date), NULL, 1, 1, 2516642, CAST(N'2021-03-20' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (3, CAST(N'2021-03-01' AS Date), NULL, 2, 1, 5956641, CAST(N'2021-03-20' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (4, CAST(N'2021-02-13' AS Date), N'cash', 1, 1, 3946272, CAST(N'2021-03-20' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (5, CAST(N'2010-01-01' AS Date), NULL, 3, 1, 3453456, CAST(N'2021-03-16' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (7, CAST(N'2021-02-14' AS Date), N'cash', 2, 1, 5555500, CAST(N'2021-03-16' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (8, CAST(N'2021-02-14' AS Date), N'cash', 1, 1, 1973136, CAST(N'2021-03-20' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (10, CAST(N'2021-02-16' AS Date), N'cash', 4, 0, 150000, CAST(N'2021-03-16' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (11, CAST(N'2021-02-19' AS Date), N'cash', 10, 0, 111000, CAST(N'2021-03-16' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (12, CAST(N'2021-02-19' AS Date), N'cash', 10, 0, NULL, NULL)
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (13, CAST(N'2021-02-19' AS Date), N'cash', 1, 1, 6664950, CAST(N'2021-03-15' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (14, CAST(N'2021-02-21' AS Date), N'cash', 1, 1, 65934, CAST(N'2021-03-14' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (15, CAST(N'2021-03-01' AS Date), N'cash', 2, 1, 0, CAST(N'2021-04-21' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (16, CAST(N'2021-03-22' AS Date), N'cash', 3, 1, 5000000, CAST(N'2021-04-21' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (17, CAST(N'2021-03-22' AS Date), N'cash', 11, 0, NULL, NULL)
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (18, CAST(N'2021-03-22' AS Date), N'cash', 10, 0, NULL, NULL)
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (19, CAST(N'2021-03-24' AS Date), N'cash', 1, 0, NULL, NULL)
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (20, CAST(N'2021-03-29' AS Date), N'cash', 1, 1, 17660000, CAST(N'2021-04-21' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (21, CAST(N'2021-03-29' AS Date), N'cash', 1, 0, NULL, NULL)
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (22, CAST(N'2021-03-30' AS Date), N'cash', 1, 1, 4735704, CAST(N'2021-03-30' AS Date))
INSERT [dbo].[Bill] ([id], [date], [paymentmethod], [customerID], [status], [paidMoney], [paidDate]) VALUES (23, CAST(N'2021-04-21' AS Date), N'cash', 12, 1, 6413136, CAST(N'2021-04-21' AS Date))
SET IDENTITY_INSERT [dbo].[Bill] OFF
GO
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (1, 1, 444, 99)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (1, 2, 500, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (1, 3, 100, 4444)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (2, 1, 500, 100)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (2, 2, 222, 11111)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (3, 1, 121, 12121)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (3, 2, 500, 100)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (3, 3, 444, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (4, 1, 444, 4444)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (4, 3, 444, 4444)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (5, 1, 100, 99)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (5, 2, 666, 666)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (5, 3, 300, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (7, 2, 100, 55555)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (8, 2, 444, 4444)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (10, 1, 50, 5000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (10, 2, 100, 3000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (10, 3, 50, 2000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (11, 2, 444, 666)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (12, 1, 444, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (12, 2, 100, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (13, 1, 666, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (13, 2, 50, 99)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (14, 2, 666, 99)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (16, 2, 1000, 5000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (17, 2, 1000, 5000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (18, 2, 50, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (19, 1, 100, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (20, 2, 100, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (20, 3, 1000, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (20, 4, 666, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (21, 2, 666, 99)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (22, 3, 444, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (22, 4, 444, 666)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (23, 2, 444, 10000)
INSERT [dbo].[BillLine] ([billID], [flowerID], [quantity], [price]) VALUES (23, 4, 444, 4444)
GO
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([id], [name], [phone], [address], [isfarmer]) VALUES (1, N'Hải Anh', N'0952155461 ', N'Tây Tựu', 1)
INSERT [dbo].[Customer] ([id], [name], [phone], [address], [isfarmer]) VALUES (2, N'Ngọc Lan', N'0954651648', N'Thôn Thượng', 0)
INSERT [dbo].[Customer] ([id], [name], [phone], [address], [isfarmer]) VALUES (3, N'Việt Anh', N'0977717477', N'Hòa Lạc', 0)
INSERT [dbo].[Customer] ([id], [name], [phone], [address], [isfarmer]) VALUES (4, N'Quốc Việt', N'0969696969', N'Bờ Đầm', 1)
INSERT [dbo].[Customer] ([id], [name], [phone], [address], [isfarmer]) VALUES (10, N'Lê Văn Đỗ', N'0965646565', N'Đức', 0)
INSERT [dbo].[Customer] ([id], [name], [phone], [address], [isfarmer]) VALUES (11, N'Sơn NT', N'05313513030', N'Hà Đông', 0)
INSERT [dbo].[Customer] ([id], [name], [phone], [address], [isfarmer]) VALUES (12, N'AnhBN', N'0946465464', N'Hòa Lạc', 1)
INSERT [dbo].[Customer] ([id], [name], [phone], [address], [isfarmer]) VALUES (13, N'Tuyên chick', N'0915478268', N'Cầu Đăm', 0)
SET IDENTITY_INSERT [dbo].[Customer] OFF
GO
INSERT [dbo].[department] ([id], [name]) VALUES (0, N'Khách bán')
INSERT [dbo].[department] ([id], [name]) VALUES (1, N'Khách mua')
GO
INSERT [dbo].[Feature] ([fid], [url]) VALUES (1, N'/list')
INSERT [dbo].[Feature] ([fid], [url]) VALUES (2, N'/delete')
INSERT [dbo].[Feature] ([fid], [url]) VALUES (3, N'/update')
INSERT [dbo].[Feature] ([fid], [url]) VALUES (4, N'/viewbillline')
INSERT [dbo].[Feature] ([fid], [url]) VALUES (5, N'/flower/list')
GO
INSERT [dbo].[FeatureGroup] ([fid], [gid]) VALUES (1, 1)
INSERT [dbo].[FeatureGroup] ([fid], [gid]) VALUES (1, 2)
INSERT [dbo].[FeatureGroup] ([fid], [gid]) VALUES (2, 1)
INSERT [dbo].[FeatureGroup] ([fid], [gid]) VALUES (2, 2)
INSERT [dbo].[FeatureGroup] ([fid], [gid]) VALUES (3, 2)
INSERT [dbo].[FeatureGroup] ([fid], [gid]) VALUES (4, 2)
GO
SET IDENTITY_INSERT [dbo].[Flower] ON 

INSERT [dbo].[Flower] ([id], [name], [image], [description], [quantity]) VALUES (1, N'Loa kèn', N'https://upload.wikimedia.org/wikipedia/commons/b/b7/Lilium_longiflorum.jpg', N'Đẹp vcl', 294)
INSERT [dbo].[Flower] ([id], [name], [image], [description], [quantity]) VALUES (2, N'Cúc', N'https://hoanguyethy.com/wp-content/uploads/2020/02/hoa-cuc.jpg', N'Cúc vàng', -1165)
INSERT [dbo].[Flower] ([id], [name], [image], [description], [quantity]) VALUES (3, N'Ly', N'https://khbvptr.vn/wp-content/uploads/2020/11/hoa-ly-31.jpg', N'Ly cắm tết', -628)
INSERT [dbo].[Flower] ([id], [name], [image], [description], [quantity]) VALUES (4, N'Hồng', N'https://image-us.eva.vn/upload/4-2020/images/2020-10-02/image6-1601622140-384-width600height450.jpg', N'Hoa hồng đỏ', -1110)
INSERT [dbo].[Flower] ([id], [name], [image], [description], [quantity]) VALUES (5, N'Thược dược', N'https://www.hoanhavuon.com/asset/upload/image/hat-giong-hoa-thuoc-duoc-do_(9).jpg?v=20190410', N'', 0)
SET IDENTITY_INSERT [dbo].[Flower] OFF
GO
SET IDENTITY_INSERT [dbo].[Group] ON 

INSERT [dbo].[Group] ([id], [name]) VALUES (1, N'admin')
INSERT [dbo].[Group] ([id], [name]) VALUES (2, N'boss')
INSERT [dbo].[Group] ([id], [name]) VALUES (3, N'cashier')
SET IDENTITY_INSERT [dbo].[Group] OFF
GO
INSERT [dbo].[GroupAccount] ([gid], [username], [accid]) VALUES (1, N'tuyen', 1)
INSERT [dbo].[GroupAccount] ([gid], [username], [accid]) VALUES (2, N'tuyen', 1)
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [FK_Bill_Customer] FOREIGN KEY([customerID])
REFERENCES [dbo].[Customer] ([id])
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [FK_Bill_Customer]
GO
ALTER TABLE [dbo].[BillLine]  WITH CHECK ADD  CONSTRAINT [FK_BillLine_Bill1] FOREIGN KEY([billID])
REFERENCES [dbo].[Bill] ([id])
GO
ALTER TABLE [dbo].[BillLine] CHECK CONSTRAINT [FK_BillLine_Bill1]
GO
ALTER TABLE [dbo].[BillLine]  WITH CHECK ADD  CONSTRAINT [FK_BillLine_Flower1] FOREIGN KEY([flowerID])
REFERENCES [dbo].[Flower] ([id])
GO
ALTER TABLE [dbo].[BillLine] CHECK CONSTRAINT [FK_BillLine_Flower1]
GO
ALTER TABLE [dbo].[FeatureGroup]  WITH CHECK ADD  CONSTRAINT [FK_FeatureGroup_Feature] FOREIGN KEY([fid])
REFERENCES [dbo].[Feature] ([fid])
GO
ALTER TABLE [dbo].[FeatureGroup] CHECK CONSTRAINT [FK_FeatureGroup_Feature]
GO
ALTER TABLE [dbo].[FeatureGroup]  WITH CHECK ADD  CONSTRAINT [FK_FeatureGroup_Group] FOREIGN KEY([gid])
REFERENCES [dbo].[Group] ([id])
GO
ALTER TABLE [dbo].[FeatureGroup] CHECK CONSTRAINT [FK_FeatureGroup_Group]
GO
ALTER TABLE [dbo].[GroupAccount]  WITH CHECK ADD  CONSTRAINT [FK_GroupAccount_Account] FOREIGN KEY([accid])
REFERENCES [dbo].[Account] ([accid])
GO
ALTER TABLE [dbo].[GroupAccount] CHECK CONSTRAINT [FK_GroupAccount_Account]
GO
ALTER TABLE [dbo].[GroupAccount]  WITH CHECK ADD  CONSTRAINT [FK_GroupAccount_Group] FOREIGN KEY([gid])
REFERENCES [dbo].[Group] ([id])
GO
ALTER TABLE [dbo].[GroupAccount] CHECK CONSTRAINT [FK_GroupAccount_Group]
GO
