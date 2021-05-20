document.addEventListener("DOMContentLoaded", function () {

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep++;
                    this.updateForm();
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // TODO: Validation

            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;

            // TODO: get data from inputs and show them in summary
          console.log(this.currentStep);
          if (this.currentStep === 5) {

                // get inputs
                // get inputs form checked checkboxes
                let checkboxesChecked = form.querySelectorAll('[data-step="1"] input:checked');
                let checkboxDescriptions = [];
                for (let i = 0; i < checkboxesChecked.length; i++) {
                    checkboxDescriptions.push(checkboxesChecked[i].parentElement
                        .querySelector(".description").innerText);
                }

                // get number of bags
                let bags = form.querySelector('[data-step="2"] input');

                // get foundation name
                let radiobuttonChecked = form.querySelector('[data-step="3"] input:checked');
                let radiobuttonTitle = radiobuttonChecked.parentElement.querySelector(".title").innerText;

                //get addresses and terms
                let addressesAndTermsInputs = form.querySelectorAll('[data-step="4"] input');
                let addressesAndTerms = [];
                let addedInformation = form.querySelector('[data-step="4"] textarea');
                for (let i = 0; i < addressesAndTermsInputs.length; i++) {
                    addressesAndTerms.push(addressesAndTermsInputs[i].value);
                }


                // save current summary
                // insert donations from checkboxes and bags number
                let summary = form.querySelector('[data-step="5"] .summary');
                let summaryTexts = summary.querySelectorAll(".summary--text");
                for (let i = 0; i < summaryTexts.length; i++) {
                    summaryTexts[i].innerText = "";
                }

                // insert bags number
                let textDonations = "";
                if (bags.value === 1) {
                    textDonations = bags.value + " worek: ";
                }
                if (bags.value > 1 && bags.value < 5) {
                    textDonations = bags.value + " worki: ";
                }
                if (bags.value > 4) {
                    textDonations = bags.value + " worków: ";
                }

                // insert donations
                for (let i = 0; i < checkboxDescriptions.length; i++) {
                    if (i < checkboxDescriptions.length - 1) {
                        textDonations += checkboxDescriptions[i] + ", ";
                    } else {
                        textDonations += checkboxDescriptions[i] + ".";
                    }
                }
                summaryTexts[0].innerText = textDonations;

                // insert foundation name
                const foundation = "Dla fundacji: " + radiobuttonTitle;
                summaryTexts[1].innerText = foundation;

                // insert addresses and datetime
                let summaryAddressAndDateTime = summary.querySelectorAll(".form-section--column > ul");
                let summaryAddress = summaryAddressAndDateTime[0].querySelectorAll("li");
                for (let i = 0; i < summaryAddress.length; i++) {
                    summaryAddress[i].innerText = "";
                    summaryAddress[i].innerText = addressesAndTerms[i];
                }

                let summaryDateTime = summaryAddressAndDateTime[1].querySelectorAll("li");
                for (let i = 0; i < summaryDateTime.length; i++) {
                    if (i < summaryDateTime.length - 1) {
                        summaryDateTime[i].innerText = "";
                        summaryDateTime[i].innerText = addressesAndTerms[i + 4];
                    } else {
                        summaryDateTime[i].innerText = "";
                        summaryDateTime[i].innerText = addedInformation.value;
                    }
                }
                
            }

        }

    }

    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }
});
