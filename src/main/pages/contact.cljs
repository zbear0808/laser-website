(ns main.pages.contact
  (:require [helix.core :refer [defnc]]
            [helix.dom :as d]
            [helix.hooks :as hooks]))

(defnc contact-page []
  (let [[form-data set-form-data!] (hooks/use-state {:name ""
                                                      :email ""
                                                      :subject ""
                                                      :message ""})
        [status set-status!] (hooks/use-state nil)
        [submitting? set-submitting!] (hooks/use-state false)
        
        update-field (fn [field]
                       (fn [e]
                         (set-form-data! 
                          (fn [prev]
                            (assoc prev field (.. e -target -value))))))
        
        handle-submit (fn [e]
                        (.preventDefault e)
                        (set-submitting! true)
                        (set-status! nil)
                        ;; Dummy endpoint call - replace with actual endpoint later
                        (-> (js/fetch "https://api.example.com/inquiry"
                                      #js {:method "POST"
                                           :headers #js {"Content-Type" "application/json"}
                                           :body (js/JSON.stringify (clj->js form-data))})
                            (.then (fn [_response]
                                     (set-status! {:type "success" 
                                                   :message "Thank you! Your inquiry has been sent."})
                                     (set-form-data! {:name "" :email "" :subject "" :message ""})))
                            (.catch (fn [_error]
                                      (set-status! {:type "error"
                                                    :message "Something went wrong. Please try again later."})))
                            (.finally (fn []
                                        (set-submitting! false)))))]
    
    (d/div {:class "page contact-page"}
      (d/h1 "Inquiry Form")
      (d/p "Interested in booking or have questions? Fill out the inquiry form below and I'll get back to you!")
      
      (d/div {:class "inquiry-form-container"}
        #_(d/h2 {:class "form-title"} "Inquiry Form")
        
        (d/form {:class "inquiry-form"
                 :on-submit handle-submit}
          
          (d/div {:class "form-group"}
            (d/label {:for "name" :class "form-label"} "Name")
            (d/input {:type "text"
                      :id "name"
                      :name "name"
                      :class "form-input"
                      :value (:name form-data)
                      :on-change (update-field :name)
                      :required true
                      :placeholder "Your name"}))
          
          (d/div {:class "form-group"}
            (d/label {:for "email" :class "form-label"} "Email")
            (d/input {:type "email"
                      :id "email"
                      :name "email"
                      :class "form-input"
                      :value (:email form-data)
                      :on-change (update-field :email)
                      :required true
                      :placeholder "your@email.com"}))
          
          (d/div {:class "form-group"}
            (d/label {:for "subject" :class "form-label"} "Subject")
            (d/input {:type "text"
                      :id "subject"
                      :name "subject"
                      :class "form-input"
                      :value (:subject form-data)
                      :on-change (update-field :subject)
                      :required true
                      :placeholder "Booking inquiry, question, etc."}))
          
          (d/div {:class "form-group"}
            (d/label {:for "message" :class "form-label"} "Message")
            (d/textarea {:id "message"
                         :name "message"
                         :class "form-input form-textarea"
                         :value (:message form-data)
                         :on-change (update-field :message)
                         :required true
                         :rows 5
                         :placeholder "Tell me about your event, date, location, and any other details..."}))
          
          (when status
            (d/div {:class (str "form-status " (:type status))}
              (:message status)))
          
          (d/button {:type "submit"
                     :class "btn btn-solid form-submit-btn"
                     :disabled submitting?}
            (if submitting? "Sending..." "Send Inquiry")))))))
