$("body").bgStretcher({
	images: ["$ctx/upload/testimgs/slidebox-06.jpg", "./v3.1.2/sample-2.jpg", "./v3.1.2/sample-1.jpg", "./v3.1.2/sample-3.jpg"],
	imageWidth: 1600,
	imageHeight: 1200,
	buttonNext: ".next",
	buttonPrev: ".prev",
	pagination: ".pagination",
	sliderCallbackFunc: bgStretcherCallback
});