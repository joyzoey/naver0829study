<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<link href="https://fonts.googleapis.com/css2?family=Jua&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<link rel="stylesheet" href="https://www.t2tea.com/on/demandware.static/-/Library-Sites-T2SharedLibrary/en_AU/v1699102948817/css/t2-custom-defaults.css">
	<link rel="stylesheet" href="../libs/css/hompage.css">
	
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-element-bundle.min.js"></script>

	<style>
		.sw-main img {
		    width: 100%;
		    height : 500px;
		    margin: auto;
		    display: block;
		}
		h1 {
			font-family: 'Nanum Pen Script';
			margin: auto;
			text-align: center;
		}
		.teaInfos {
		    height: 330px;
		    overflow: hidden;
		    font-family: 'Jua';
    	}
    	.prd-md {
			margin: 0px 0 100px;
			text-align: center;
    	}
    	
    	.prd-md .prod {
		    float: left;
		    width: 320px;
		    height: 430px;
		}
		
		.homepage-wrapper .home-tea-types .container {
		    max-width: 1662px;
		    margin-bottom: 0
		}
		
		@media(min-width: 768px) {
		    .homepage-wrapper .home-tea-types .container {
		        margin-bottom:0
		    }
		}
		
		
		
		.homepage-wrapper .home-tea-types .splide {
		    margin-top: 1.5rem;
		    margin-bottom: 1.5rem
		}
		
		.homepage-wrapper .home-tea-types .splide .splide__track {
		    overflow: visible
		}
		
		.homepage-wrapper .home-tea-types .splide .splide__slide {
		    width: 160px!important;
		    margin-right: 1rem!important
		}
		
		
		
		.homepage-wrapper .home-tea-types .splide .splide__slide img {
		    transition: opacity .3s ease-in-out,transform .3s ease-in-out
		}
		
		.homepage-wrapper .home-tea-types .splide .splide__slide img.teaImageDefault {
		    position: absolute;
		    width: 160px;
		    height: 119.5px;
		    transform: scale(1)
		}
		
		
		
		.homepage-wrapper .home-tea-types .splide .splide__slide img.teaImageHover {
		    position: relative;
		    width: 160px;
		    height: 119.5px;
		    opacity: 0;
		    transform: scale(.8)
		}
		
		.homepage-wrapper .home-tea-types .splide .splide__slide:hover img.teaImageDefault {
		    opacity: 0;
		    transform: scale(.8)
		}
		
		.homepage-wrapper .home-tea-types .splide .splide__slide:hover img.teaImageHover {
		    opacity: 1;
		    transform: scale(1)
		}
		
		.homepage-wrapper .home-tea-types .splide .splide__slide .h9 {
		    margin-top: .5rem
		}
		
		.homepage-wrapper .home-tea-types .splide .link-md {
		    margin-top: .5rem
		}
		
		.homepage-wrapper .home-tea-types .swiper-container {
		    padding: 0
		}
		
		.homepage-wrapper .home-tea-types .swiper-wrapper {
		    margin-bottom: 1rem
		}
		
		
		
		.homepage-wrapper .home-tea-types .swiper-wrapper h3 {
		    max-width: 200px
		}
		
		.homepage-wrapper .home-tea-types .swiper-slide {
		    width: 128px;
		    margin-right: 1rem!important
		}
		
		@media(min-width: 768px) {
		    .homepage-wrapper .home-tea-types .swiper-slide {
		        width:192px;
		        height: 144px;
		        padding: 0 2rem;
		        margin-right: 1.5rem!important
		    }
		}
		
		.homepage-wrapper .splide__list {
		    backface-visibility: hidden;
		    display: -ms-flexbox;
		    display: flex;
		    height: 100%;
		    margin: 0!important;
		    padding: 0!important
		}
		
		.homepage-wrapper .splide__slide {
		    backface-visibility: hidden;
		    box-sizing: border-box;
		    -ms-flex-negative: 0;
		    flex-shrink: 0;
		    list-style-type: none!important;
		    margin: 0;
		    position: relative
		}
		
		.homepage-wrapper .splide__slide img {
		    vertical-align: bottom
		}
		
		.homepage-wrapper .splide__slide {
		    -webkit-tap-highlight-color: transparent
		}
		
		.homepage-wrapper .splide__slide:focus {
		    outline: 0
		}
		@supports(outline-offset: -3px) {
		    .homepage-wrapper .splide__slide:focus-visible {
		        outline:3px solid #0bf;
		        outline-offset: -3px
		    }
		}
		
		@media screen and (-ms-high-contrast:none) {
		    .homepage-wrapper .splide__slide:focus-visible {
		        border: 3px solid #0bf
		    }
		}
		
		@supports(outline-offset: -3px) {
		    .homepage-wrapper .splide.is-focus-in .splide__slide:focus {
		        outline:3px solid #0bf;
		        outline-offset: -3px
		    }
		}
		
		@media screen and (-ms-high-contrast:none) {
		    .homepage-wrapper .splide.is-focus-in .splide__slide:focus {
		        border: 3px solid #0bf
		    }
		
		    .homepage-wrapper .splide.is-focus-in .splide__track>.splide__list>.splide__slide:focus {
		        border-color: #0bf
		    }
		}
		.homepage-wrapper .splide__arrow {
		    -ms-flex-align: center;
		    align-items: center;
		    background: #ccc;
		    border: 0;
		    border-radius: 50%;
		    cursor: pointer;
		    display: -ms-flexbox;
		    display: flex;
		    height: 2em;
		    -ms-flex-pack: center;
		    justify-content: center;
		    opacity: .7;
		    padding: 0;
		    position: absolute;
		    top: 50%;
		    transform: translateY(-50%);
		    width: 2em;
		    z-index: 1
		}
		
		.homepage-wrapper .splide__arrow svg {
		    fill: #000;
		    height: 1.2em;
		    width: 1.2em
		}
		
		.homepage-wrapper .splide__arrow:hover:not(:disabled) {
		    opacity: .9
		}
		
		.homepage-wrapper .splide__arrow:disabled {
		    opacity: .3
		}
		
		.homepage-wrapper .splide__arrow:focus-visible {
		    outline: 3px solid #0bf;
		    outline-offset: 3px
		}
		
		.homepage-wrapper .splide__arrow--prev {
		    left: 1em
		}
		
		.homepage-wrapper .splide__arrow--prev svg {
		    transform: scaleX(-1)
		}
		
		.homepage-wrapper .splide__arrow--next {
		    right: 1em
		}
		
		.homepage-wrapper .splide.is-focus-in .splide__arrow:focus {
		    outline: 3px solid #0bf;
		    outline-offset: 3px
		}
		.homepage-wrapper .splide__arrows--rtl .splide__arrow--prev {
		    left: auto;
		    right: 1em
		}
		
		.homepage-wrapper .splide__arrows--rtl .splide__arrow--prev svg {
		    transform: scaleX(1)
		}
		
		.homepage-wrapper .splide__arrows--rtl .splide__arrow--next {
		    left: 1em;
		    right: auto
		}
		
		.homepage-wrapper .splide__arrows--rtl .splide__arrow--next svg {
		    transform: scaleX(-1)
		}
		
		.homepage-wrapper .splide__arrows--ttb .splide__arrow {
		    left: 50%;
		    transform: translate(-50%)
		}
		
		.homepage-wrapper .splide__arrows--ttb .splide__arrow--prev {
		    top: 1em
		}
		
		.homepage-wrapper .splide__arrows--ttb .splide__arrow--prev svg {
		    transform: rotate(-90deg)
		}
		
		.homepage-wrapper .splide__arrows--ttb .splide__arrow--next {
		    bottom: 1em;
		    top: auto
		}
		
		.homepage-wrapper .splide__arrows--ttb .splide__arrow--next svg {
		    transform: rotate(90deg)
		}
		
		.homepage-wrapper .splide__pagination--ttb {
		    bottom: 0;
		    display: -ms-flexbox;
		    display: flex;
		    -ms-flex-direction: column;
		    flex-direction: column;
		    left: auto;
		    padding: 1em 0;
		    right: .5em;
		    top: 0
		}
		</style>
</head>
<body>
	<header>
		<jsp:include page="/common/header.jsp"/>
	</header>

	<div role="main" id="maincontentT2">
		<div style="margin: 10px;" class="sw-main">
			<h1 style="margin-top: 40px;">나혜의 차 마스터에 오신 걸 환영합니다!</h1>
			<swiper-container class="mySwiper" navigation="true">
				<swiper-slide><img src="home1.png"></swiper-slide> 
				<swiper-slide><img src="home2.png"></swiper-slide>
				<swiper-slide><img src="home3.png"></swiper-slide>
				<swiper-slide><img src="home4.png"></swiper-slide>
				<swiper-slide><img src="home5.png"></swiper-slide> 
			</swiper-container>
		</div>

		<div class="full-width-content-asset teaInfos">

			<div class="content-asset-body">
				<div class="t2-content">
					<div class="homepage-wrapper">
						<div class="home-tea-types">
							<div class="container-fluid px-0">
								<div
									class="splide splide--loop splide--ltr splide--draggable is-active is-overflow is-initialized"
									id="splide01" role="region" aria-roledescription="carousel">
									<div class="splide__arrows splide__arrows--ltr">
										<button class="splide__arrow splide__arrow--prev"
											type="button" aria-label="Previous slide"
											aria-controls="splide01-track"
											style="top:850px;">
											<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 40 40"
												width="40" height="40" focusable="false">
												<path
													d="m15.5 0.932-4.3 4.38 14.5 14.6-14.5 14.5 4.3 4.4 14.6-14.6 4.4-4.3-4.4-4.4-14.6-14.6z"></path>
											</svg>
										</button>
										<button class="splide__arrow splide__arrow--next"
											type="button" aria-label="Next slide"
											aria-controls="splide01-track"
											style="top:850px;">
											<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 40 40"
												width="40" height="40" focusable="false">
												<path
													d="m15.5 0.932-4.3 4.38 14.5 14.6-14.5 14.5 4.3 4.4 14.6-14.6 4.4-4.3-4.4-4.4-14.6-14.6z"></path>
											</svg>
										</button>
									</div>
									<div
										class="splide__track splide__track--loop splide__track--ltr splide__track--draggable"
										style="transition-duration: 0ms; padding-left: 0px; padding-right: 0px;"
										id="splide01-track" aria-live="off" aria-atomic="true"
										aria-busy="false">
										<ul class="splide__list" id="splide01-list"
											role="presentation" style="transform: translateX(-2004.4px);">

											<li class="splide__slide" id="splide01-slide01" role="group"
												aria-roledescription="slide" aria-label="1 of 15"
												style="width: calc(33.3333%);" aria-hidden="true">
												<a
												tabindex="-1" data-bs-toggle="modal"
												data-bs-target="#myModal"> 
												<picture>
													<source
														srcset="
												  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/rXdbJ/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-black-tea, 
												  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/rXdbJ/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-black-tea 2x
												  "
														data-srcset="
												  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/rXdbJ/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-black-tea, 
												  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/rXdbJ/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-black-tea 2x
												  ">

													<img alt="Black Tea brewed tea" style="" loading="lazy"
														class="teaImageDefault ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture> <picture>
													<source
														srcset="
												  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/ZMdOA/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-black-tea, 
												  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/ZMdOA/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-black-tea 2x
												  "
														data-srcset="
												  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/ZMdOA/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-black-tea, 
												  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/ZMdOA/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-black-tea 2x
												  ">
													<img alt="Black Tea leaves" style="" loading="lazy"
														class="teaImageHover ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture>
													<h1 class="text-center">홍차</h1>
											</a></li>


											<li class="splide__slide" id="splide01-slide02" role="group"
												aria-roledescription="slide" aria-label="2 of 15"
												style="width: calc(33.3333%);" aria-hidden="true"><a
												tabindex="-1" data-bs-toggle="modal"
												data-bs-target="#myModa2"> <picture>
													<source
														srcset="
											  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/PMKj8/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-green-tea, 
											  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/PMKj8/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-green-tea 2x
											  "
														data-srcset="
											  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/PMKj8/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-green-tea, 
											  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/PMKj8/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-green-tea 2x
											  ">

													<img alt="Green Tea brewed tea" style="" loading="lazy"
														class="teaImageDefault ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture> <picture>
													<source
														srcset="
											  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/1lO6p/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-green-tea, 
											  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/1lO6p/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-green-tea 2x
											  "
														data-srcset="
											  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/1lO6p/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-green-tea, 
											  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/1lO6p/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-green-tea 2x
											  ">

													<img alt="Green Tea leaves" style="" loading="lazy"
														class="teaImageHover ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture>
													<h1 class="text-center">녹차</h1>
											</a></li>


											<li class="splide__slide is-visible" id="splide01-slide04"
												role="group" aria-roledescription="slide"
												aria-label="4 of 15" style="width: calc(33.3333%);"><a
												tabindex="-1" data-bs-toggle="modal"
												data-bs-target="#myModa3"> <picture>
													<source
														srcset="
									  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/KwqKz/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-chai, 
									  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/KwqKz/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-chai 2x
									  "
														data-srcset="
									  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/KwqKz/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-chai, 
									  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/KwqKz/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-chai 2x
									  ">

													<img alt="Chai brewed tea" style="" loading="lazy"
														class="teaImageDefault ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture> <picture>
													<source
														srcset="
									  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/yKaDZ/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-chai, 
									  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/yKaDZ/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-chai 2x
									  "
														data-srcset="
									  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/yKaDZ/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-chai, 
									  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/yKaDZ/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-chai 2x
									  ">

													<img alt="Chai leaves" style="" loading="lazy"
														class="teaImageHover ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture>
													<h1 class="text-center">차이</h1>
											</a></li>


											<li class="splide__slide is-visible is-prev"
												id="splide01-slide05" role="group"
												aria-roledescription="slide" aria-label="5 of 15"
												style="width: calc(33.3333%);"><a tabindex="-1"
												data-bs-toggle="modal" data-bs-target="#myModa4"> <picture>
													<source
														srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/zKv2l/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-herbal-tea-and-floral-tisane, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/zKv2l/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-herbal-tea-and-floral-tisane 2x
							  "
														data-srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/zKv2l/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-herbal-tea-and-floral-tisane, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/zKv2l/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-herbal-tea-and-floral-tisane 2x
							  ">

													<img alt="Herbal Tea &amp; Floral Tisane brewed tea"
														style="" loading="lazy"
														class="teaImageDefault ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture> <picture>
													<source
														srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/Gwkod/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-herbal-tea-and-floral-tisane, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/Gwkod/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-herbal-tea-and-floral-tisane 2x
							  "
														data-srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/Gwkod/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-herbal-tea-and-floral-tisane, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/Gwkod/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-herbal-tea-and-floral-tisane 2x
							  ">
													<img alt="Herbal Tea &amp; Floral Tisane leaves" style=""
														loading="lazy"
														class="teaImageHover ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture>
													<h1 class="text-center">꽃차</h1>
											</a></li>

											<li class="splide__slide is-visible is-active"
												id="splide01-slide06" role="group"
												aria-roledescription="slide" aria-label="6 of 15"
												style="width: calc(33.3333%);"><a tabindex="-1"
												data-bs-toggle="modal" data-bs-target="#myModa5"> <picture>
													<source
														srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/eMd36/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-fruit-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/eMd36/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-fruit-tea 2x
							  "
														data-srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/eMd36/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-fruit-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/eMd36/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-fruit-tea 2x
							  ">

													<img alt="Fruit Tea brewed tea" style="" loading="lazy"
														class="teaImageDefault ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture> <picture>
													<source
														srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/oKdbd/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-fruit-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/oKdbd/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-fruit-tea 2x
							  "
														data-srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/oKdbd/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-fruit-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/oKdbd/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-fruit-tea 2x
							  ">

													<img alt="Fruit Tea leaves" style="" loading="lazy"
														class="teaImageHover ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture>
													<h1 class="text-center">과일차</h1>
											</a></li>


											<li class="splide__slide is-visible is-next"
												id="splide01-slide07" role="group"
												aria-roledescription="slide" aria-label="7 of 15"
												style="width: calc(33.3333%);"><a tabindex="-1"
												data-bs-toggle="modal" data-bs-target="#myModa6"> <picture>
													<source
														srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/YMd09/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-oolong-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/YMd09/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-oolong-tea 2x
							  "
														data-srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/YMd09/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-oolong-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/YMd09/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-oolong-tea 2x
							  ">

													<img alt="Oolong Tea brewed tea" style="" loading="lazy"
														class="teaImageDefault ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture> <picture>
													<source
														srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/4l2M7/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-oolong-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/4l2M7/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-oolong-tea 2x
							  "
														data-srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/4l2M7/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-oolong-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/4l2M7/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-oolong-tea 2x
							  ">

													<img alt="Oolong Tea leaves" style="" loading="lazy"
														class="teaImageHover ls-is-cached lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture>
													<h1 class="text-center">우롱차</h1>
											</a></li>


											<li class="splide__slide is-visible" id="splide01-slide08"
												role="group" aria-roledescription="slide"
												aria-label="8 of 15" style="width: calc(33.3333%);"><a
												tabindex="-1" data-bs-toggle="modal"
												data-bs-target="#myModa7"> <picture>
													<source
														srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/Owe4l/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-white-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/Owe4l/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-white-tea 2x
							  "
														data-srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/Owe4l/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-white-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/Owe4l/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-white-tea 2x
							  ">

													<img alt="White Tea brewed tea" style="" loading="lazy"
														class="teaImageDefault lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture> <picture>
													<source
														srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/RMpyZ/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-white-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/RMpyZ/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-white-tea 2x
							  "
														data-srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/RMpyZ/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-white-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/RMpyZ/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-white-tea 2x
							  ">

													<img alt="White Tea leaves" style="" loading="lazy"
														class="teaImageHover lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture>
													<h1 class="text-center">백차</h1>
											</a></li>

											<li class="splide__slide" id="splide01-slide09" role="group"
												aria-roledescription="slide" aria-label="9 of 15"
												style="width: calc(33.3333%);" aria-hidden="true"><a
												tabindex="-1" data-bs-toggle="modal"
												data-bs-target="#myModa8"> <picture>
													<source
														srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/qpdM6/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-african-rooibos-and-honeybush-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/qpdM6/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-african-rooibos-and-honeybush-tea 2x
							  "
														data-srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/qpdM6/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-african-rooibos-and-honeybush-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/qpdM6/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-african-rooibos-and-honeybush-tea 2x
							  ">

													<img alt="African Rooibos &amp; Honeybush Tea brewed tea"
														style="" loading="lazy" class="teaImageDefault lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture> <picture>
													<source
														srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/LwnPN/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-african-rooibos-and-honeybush-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/LwnPN/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-african-rooibos-and-honeybush-tea 2x
							  "
														data-srcset="
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/LwnPN/size=160&amp;quality=70&amp;compresstype=JPEG&amp;ext=webp/image-african-rooibos-and-honeybush-tea, 
							  https://cdn.intelligencebank.com/au/share/NOrD/yKaMp/LwnPN/size=320&amp;quality=40&amp;compresstype=JPEG&amp;ext=webp/image-african-rooibos-and-honeybush-tea 2x
							  ">

													<img alt="African Rooibos &amp; Honeybush Tea leaves"
														style="" loading="lazy" class="teaImageHover lazyloaded"
														src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														data-src="https://cdn.intelligencebank.com/au/share/NOrD/n2gez/LW6oN/original/image-lazy"
														decoding="async"> </picture>
													<h1 class="text-center">허브차</h1>
											</a></li>


										</ul>
									</div>
								</div>
							</div>
		<div id="juClick"></div>

		<script	src="https://cdn.jsdelivr.net/npm/@splidejs/splide@latest/dist/js/splide.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/@splidejs/splide-extension-auto-scroll@latest/dist/js/splide-extension-auto-scroll.min.js"></script>
		<script>
			$(function() {
				$('button[name=clsModal]').on('click', function() {
					$(':focus').blur();
				});
			});
			
			document.addEventListener("DOMContentLoaded", function () {
		          new Splide(".splide", {
		            perPage: 3,
		            perMove: 1,
		            type: "loop",
		            snap: true,
		            lazyload: "nearby",
		            focus: 2,
		            autoScroll: {
		              speed: 0.45,
		            },
		            pagination: false,
		            pauseOnFocus: true,
		            pauseOnHover: true,
		            preloadPages: 2,
		            keyboard: "focused",
		          }).mount(window.splide.Extensions);
		    });
			
		
		</script>

						</div>
					</div>
				</div>
			</div>
		</div>




		<footer style="position: absolute; bottom: 0; width: 100%">
			<jsp:include page="/common/footer.jsp" />
		</footer>
		
		<!-- Modals Start -->
			<div class="modal" id="myModal">
			
			  <div class="modal-dialog">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">홍차</h4>
			        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			        찻잎을 산화발효시켜서 마시는 대표적인 차로 유럽인이 마시는 차를 차의 빛깔이 붉다고 하여 홍차라고 부르던 것을 그대로 받아들여 사용하기 시작했다.
			        영국에선 Black Tea라고도 하는데 녹차와 우룽차의 차이를 설명하는 통역 과정을 거치면서 영어 'Black Tea'의 어원이 되었다는 것이 현재 가장 강력한 가설이 되고 있다.
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" name="clsModal" data-bs-dismiss="modal">닫기</button>
			      </div>
			
			    </div>
			  </div>
			  
			</div>
			
			<div class="modal" id="myModa2">
			
			  <div class="modal-dialog">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">녹차</h4>
			        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			        발효시키지 않은 찻잎을 사용해서 만든 차로  딴 잎을 즉시 가열하여 산화효소를 파괴시켜 녹색을 그대로 유지하는 동시에, 수분을 증발시켜 잎을 흐늘흐늘하게 말기 좋은 상태로 말린다. 
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" name="clsModal" data-bs-dismiss="modal">닫기</button>
			      </div>
			
			    </div>
			  </div>
			  
			</div>
			
			<div class="modal" id="myModa3">
			
			  <div class="modal-dialog">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">차이</h4>
			        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			        홍차와 계피, 카다멈, 정향, 생강과 같은 향신료를 혼합한 차로 따뜻한 특성과 소화와 면역력에 도움을 준다고 알려져 있다.
					차이는 다소 강렬하고 확실한 풍미를 가지는 차이며, 이 중 약간의 단맛을 동반하는 경우도 있다. 일반적으로 우유와 함께 마시게 되며 설탕이나 꿀로 단 마맛을 더하기도 한다. 
					차는 뜨겁게 또는 얼음을 넣어 시원하게 즐길 수도 있어 4계절 모두 매력적인 차라고 할 수 있습니다.
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" name="clsModal" data-bs-dismiss="modal">닫기</button>
			      </div>
			
			    </div>
			  </div>
			  
			</div>
			
			<div class="modal" id="myModa4">
			
			  <div class="modal-dialog">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">꽃차</h4>
			        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			        꽃을 이용하거나 차에 꽃을 혼합하여 만든 차를 말한다.
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" name="clsModal" data-bs-dismiss="modal">닫기</button>
			      </div>
			
			    </div>
			  </div>
			  
			</div>
			
			<div class="modal" id="myModa5">
			
			  <div class="modal-dialog">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">과일차</h4>
			        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			        과일차는 말린 과일을 활용하여 단맛과 깊은 향을 즐길 수 있을 뿐만 아니라 영양성분까지 고루 섭취할 수 있다. 
			        과일들은 비타민 C가 풍부하며, 말린 과일은 수분 함량이 낮아져 단맛이 강해지고 향도 더욱 진하게 증가합니다. 
			        따라서, 건조 과일을 이용한 차는 겨울철에 부족하기 쉬운 비타민 섭취에 큰 도움이 된다.
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" name="clsModal" data-bs-dismiss="modal">닫기</button>
			      </div>
			
			    </div>
			  </div>
			  
			</div>
			
			<div class="modal" id="myModa6">
			
			  <div class="modal-dialog">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">우롱차</h4>
			        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			        녹차와 홍차의 중간적인 성질을 가진 반발효차로 처음에 햇볕을 쬐어서 시들게 한 후 실내로 옮겨서 때때로 휘저어 섞어서 수분을 제거하며, 그 사이에 약간 발효하게 한 후 솥에다 볶아서 효소작용을 멈추게 한다. 이것을 잘 비벼서 건조시킨 후 제품을 만든다.

			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" name="clsModal" data-bs-dismiss="modal">닫기</button>
			      </div>
			
			    </div>
			  </div>
			  
			</div>
			
			<div class="modal" id="myModa7">
			
			  <div class="modal-dialog">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">백차</h4>
			        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			        백차는 솜털이 덮인 차의 어린 싹을 따서 덖거나 비비기를 하지 않고 그대로 건조시켜 만든 차로서 특별한 가공과정을 거치지 않고 그대로 건조시키면서 약간의 발효만 일어나도록 하기 때문에 제조법이 가장 간단한 차이다.
			        차 싹이 크고 솜털이 많은 품종을 선택하여 이십사절기 중 청명 전후 2일 사이에 걸쳐 제조한다. 
			      	향기가 맑고 맛이 산뜻하며 여름철에 열을 내려주는 작용이 강하여 한약재로도 많이 사용되고 있다. 
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" name="clsModal" data-bs-dismiss="modal">닫기</button>
			      </div>
			
			    </div>
			  </div>
			  
			</div>
			
			<div class="modal" id="myModa8">
			
			  <div class="modal-dialog">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">허브차</h4>
			        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			        찻잎 이외의 허브로 우려낸 차이다. 대표적인 차로 캐모마일, 페퍼민트, 루이보스 등이 있다.
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" name="clsModal" data-bs-dismiss="modal">닫기</button>
			      </div>
			
			    </div>
			  </div>
			  
			</div>
		<!-- Modals End -->
</body>
</html>