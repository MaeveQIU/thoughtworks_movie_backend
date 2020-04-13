CREATE DATABASE movies;
USE movies;

DROP TABLE movie_basic;
CREATE TABLE movie_basic (
movie_id INT PRIMARY KEY,
title VARCHAR(80),
year INT,
genres VARCHAR(160),
rating DOUBLE,
directors VARCHAR(160),
casts VARCHAR(255),
duration VARCHAR(20),
image TEXT,
countries VARCHAR(80),
tags VARCHAR(255),
summary TEXT
);
INSERT INTO movie_basic VALUES 
(1292052, 
'肖申克的救赎', 
1994, 
'犯罪,剧情', 
9.7, 
'弗兰克·德拉邦特', 
'蒂姆·罗宾斯,摩根·弗里曼,鲍勃·冈顿', 
'142分钟', 
'http://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg',
'美国',
'经典,励志,信念,自由,人性,人生,美国,希望,剧情,成长',
'20世纪40年代末，小有成就的青年银行家安迪（蒂姆·罗宾斯 Tim Robbins 饰）因涉嫌杀害妻子及她的情人而锒铛入狱。在这座名为肖申克的监狱内，希望似乎虚无缥缈，终身监禁的惩罚无疑注定了安迪接下来灰暗绝望的人生。未过多久，安迪尝试接近囚犯中颇有声望的瑞德（摩根·弗里曼 Morgan Freeman 饰），请求对方帮自己搞来小锤子。以此为契机，二人逐渐熟稔，安迪也仿佛在鱼龙混杂、罪恶横生、黑白混淆的牢狱中找到属于自己的求生之道。他利用自身的专业知识，帮助监狱管理层逃税、洗黑钱，同时凭借与瑞德的交往在犯人中间也渐渐受到礼遇。表面看来，他已如瑞德那样对那堵高墙从憎恨转变为处之泰然，但是对自由的渴望仍促使他朝着心中的希望和目标前进。而关于其罪行的真相，似乎更使这一切朝前推进了一步……
本片根据著名作家斯蒂芬·金（Stephen Edwin King）的原著改编。©豆瓣');
SELECT * FROM movies.movie_basic;

DROP TABLE movie_review;
CREATE TABLE movie_review (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    movie_id INT,
    author_profile TEXT,
    author_name VARCHAR(40),
    review VARCHAR(255)
);

INSERT INTO movie_review (movie_id, author_profile, author_name, review) VALUES 
(26942674, 
'http://img9.doubanio.com/icon/u38743105-4.jpg', 
'zsn',
'讲真，这个片子我是冲阿米尔汗去看的，但阿米尔汗在其中只是个配角，虽然他贡献了里面最搞笑的片段，让我很是惊喜，但这剧的硬伤太多了，豆瓣评分略高了。 第一女主成名太过容易了，只是发了一个视频在YouTube上...'), 
(26942674, 
'http://img3.doubanio.com/icon/u51349943-2.jpg',
'Phenixus',
'抱着摔跤吧爸爸的水准，或至少同一档次的期望去看《神秘巨星》，结果大失所望，虽然综合了女权，家暴，代沟，早恋，母爱，伊斯兰等诸多深刻或煽情的主题，也有非常政治正确的导向性，比如女性的独立解放，但故事...'),
(26942674,
'http://img1.doubanio.com/icon/u63688511-18.jpg',
'凌睿',
'其实先看《神秘巨星》，后看《摔跤吧！爸爸》是比较好的，如果已经看过了《摔跤吧！爸爸》，完全可以看完《神秘巨星》后再看一遍《摔跤吧！爸爸》。 很多人观看《摔跤吧！爸爸》时，不太理解爸爸私自为女儿选择人...'),
(26942674,
'http://img9.doubanio.com/icon/u58001384-136.jpg',
'隔壁山田大王',
'二刷之后补充一下： 今天带我父母去看了这部片子，我妈从头哭到尾，不是泪点的地方她也在哭，走出影厅后跟我说她哭得脑仁儿疼…… 阿米尔·汗演得是真好。小姑娘用心唱歌那里，他震惊的、含着泪的眼神，给到我一...'),
(26942674,
'http://img1.doubanio.com/icon/user_normal.jpg',
'滔妹儿会画画',
'首先，我不质疑电影的思想及内涵，且觉得是很好的，冲着电影的立意和阿米尔汗，我给两星，但是看到女主角的人设，我实在打不出三星。 纵然女主有着以一己之力打破常规的高级思想，但是女主的实际行动及人设和她的...');
SELECT * FROM movies.movie_review;
SELECT * FROM movie_basic WHERE title LIKE '%肖申克的救赎%';
select user,host from mysql.user;




